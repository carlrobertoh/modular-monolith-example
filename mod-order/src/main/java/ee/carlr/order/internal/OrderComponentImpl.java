package ee.carlr.order.internal;

import ee.carlr.basket.Basket;
import ee.carlr.order.Order;
import ee.carlr.order.OrderComponent;
import ee.carlr.order.OrderCreationEvent;
import ee.carlr.order.OrderItem;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class OrderComponentImpl implements OrderComponent {

  private final OrderRepository orderRepository;
  private final ApplicationEventPublisher eventPublisher;

  OrderComponentImpl(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
    this.orderRepository = orderRepository;
    this.eventPublisher = eventPublisher;
  }

  @Override
  public Order createOrder(Basket basket) {
    Order order = new Order(basket.getCustomerDetails());
    basket.getProducts().forEach(product ->
            order.addOrderItem(new OrderItem(product.getName(), product.getPrice())));
    orderRepository.saveOrder(order);
    eventPublisher.publishEvent(new OrderCreationEvent(order));
    return order;
  }

  @Override
  public Order getOrder(Long orderId) {
    return orderRepository.getOrder(orderId);
  }

  @Override
  public void updateOrder(Order order) {
    orderRepository.updateOrder(order);
  }

  @Override
  public void completeOrder(Long orderId) {
    Order order = getOrder(orderId);
    order.markOrderComplete();
    updateOrder(order);
  }
}

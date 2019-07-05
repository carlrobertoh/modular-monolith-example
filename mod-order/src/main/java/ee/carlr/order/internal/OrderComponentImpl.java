package ee.carlr.order.internal;

import ee.carlr.basket.Basket;
import ee.carlr.order.Order;
import ee.carlr.order.OrderComponent;
import ee.carlr.order.OrderCreationEvent;
import ee.carlr.order.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class OrderComponentImpl implements OrderComponent {
  private final OrderRepository orderRepository;
  private final ApplicationEventPublisher eventPublisher;

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

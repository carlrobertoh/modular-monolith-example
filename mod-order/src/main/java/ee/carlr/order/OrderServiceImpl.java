package ee.carlr.order;

import ee.carlr.basket.Basket;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final ApplicationEventPublisher eventPublisher;

  OrderServiceImpl(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
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

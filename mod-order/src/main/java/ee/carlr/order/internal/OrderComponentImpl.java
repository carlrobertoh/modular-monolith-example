package ee.carlr.order.internal;

import ee.carlr.basket.internal.Basket;
import ee.carlr.order.OrderComponent;
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
}

package ee.carlr.order;

import ee.carlr.basket.internal.Basket;
import ee.carlr.order.internal.Order;

public interface OrderComponent {
  Order createOrder(Basket basket);

  Order getOrder(Long orderId);

  void updateOrder(Order order);
}

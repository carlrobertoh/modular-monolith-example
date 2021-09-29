package ee.carlr.order;

import ee.carlr.basket.Basket;

public interface OrderService {

  Order createOrder(Basket basket);

  Order getOrder(Long orderId);

  void updateOrder(Order order);

  void completeOrder(Long orderId);
}

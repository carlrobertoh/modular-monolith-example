package ee.carlr.basket;

import ee.carlr.basket.internal.Basket;

public interface BasketComponent {
  Basket createBasket(Object customerDetails);

  Basket getBasket(Long basketId);

  void addProduct(Long basketId, Long productId);

  void confirmBasket(Basket basket);
}

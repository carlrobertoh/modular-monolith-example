package ee.carlr.basket;

public interface BasketComponent {
  Basket createBasket(Object customerDetails);

  Basket getBasket(Long basketId);

  void addProduct(Long basketId, Long productId);

  void confirmBasket(Basket basket);
}

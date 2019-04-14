package ee.carlr.basket.internal;

import org.springframework.stereotype.Repository;

@Repository
class BasketRepository {
  Basket createBasket(Basket basket) {
    throw new UnsupportedOperationException();
  }

  Basket getBasket(Long basketId) {
    throw new UnsupportedOperationException();
  }

  void update(Basket basket) {
    throw new UnsupportedOperationException();
  }
}

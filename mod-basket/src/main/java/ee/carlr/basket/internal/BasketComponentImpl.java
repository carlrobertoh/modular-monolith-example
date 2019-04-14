package ee.carlr.basket.internal;

import ee.carlr.basket.BasketComponent;
import ee.carlr.product.ProductComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static ee.carlr.basket.internal.BasketState.CONFIRMED;

@Component
@RequiredArgsConstructor
class BasketComponentImpl implements BasketComponent {
  private final BasketRepository basketRepository;
  private final ProductComponent productComponent;

  @Override
  public Basket createBasket(Object customerDetails) {
    return basketRepository.createBasket(new Basket(customerDetails));
  }

  @Override
  public Basket getBasket(Long basketId) {
    return basketRepository.getBasket(basketId);
  }

  @Override
  public void addProduct(Long basketId, Long productId) {
    Basket basket = getBasket(basketId);
    basket.addProduct(productComponent.getProduct(productId));
    basketRepository.update(basket);
  }

  @Override
  public void confirmBasket(Basket basket) {
    if (CONFIRMED.equals(basket.getState()))
      throw new RuntimeException("Basket already confirmed!");

    basket.markConfirmed();
    basketRepository.update(basket);
  }
}

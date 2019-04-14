package ee.carlr.basket.internal;

import ee.carlr.product.internal.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static ee.carlr.basket.internal.BasketState.CONFIRMED;
import static ee.carlr.basket.internal.BasketState.OPEN;

@Getter
public class Basket {
  private Long basketId;
  private Object customerDetails;
  private List<Product> products = new ArrayList<>();
  private BasketState state;

  Basket(Object customerDetails) {
    this.customerDetails = customerDetails;
    this.state = OPEN;
  }

  void setBasketId(Long basketId) {
    this.basketId = basketId;
  }

  void addProduct(Product product) {
    products.add(product);
  }

  void markConfirmed() {
    this.state = CONFIRMED;
  }
}

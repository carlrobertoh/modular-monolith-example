package ee.carlr.basket;

import ee.carlr.product.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static ee.carlr.basket.BasketState.*;

@Getter
public class Basket {
  private String basketId;
  private Object customerDetails;
  private List<Product> products = new ArrayList<>();
  private BasketState state;

  public Basket(Object customerDetails) {
    this.basketId = UUID.randomUUID().toString();
    this.customerDetails = customerDetails;
    this.state = OPEN;
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void markConfirmed() {
    this.state = CONFIRMED;
  }
}

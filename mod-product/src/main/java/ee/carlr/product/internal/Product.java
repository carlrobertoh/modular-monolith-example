package ee.carlr.product.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private Double price;
}

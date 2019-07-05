package ee.carlr.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private Double price;
}

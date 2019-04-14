package ee.carlr.product.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private BigDecimal price;
}

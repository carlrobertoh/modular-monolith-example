package ee.carlr.order.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderItem {
  private String name;
  private BigDecimal price;
}

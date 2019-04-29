package ee.carlr.order.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItem {
  private String name;
  private Double price;
}

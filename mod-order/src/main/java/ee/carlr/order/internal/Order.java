package ee.carlr.order.internal;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static ee.carlr.order.internal.OrderState.ACCEPTED;
import static ee.carlr.order.internal.OrderState.OPEN;

@Getter
public class Order {
  private Long id;
  private List<OrderItem> orderItems = new ArrayList<>();
  private Object customerDetails;
  private OrderState state;

  Order(Object customerDetails) {
    this.state = OPEN;
    this.customerDetails = customerDetails;
  }

  void setId(Long id) {
    this.id = id;
  }

  void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
  }

  public void markOrderAccepted() {
    this.state = ACCEPTED;
  }
}

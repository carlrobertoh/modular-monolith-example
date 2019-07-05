package ee.carlr.order;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static ee.carlr.order.OrderState.*;

@Getter
public class Order {
  private Long id;
  private List<OrderItem> orderItems = new ArrayList<>();
  private Object customerDetails;
  private OrderState state;

  public Order(Object customerDetails) {
    this.state = OPEN;
    this.customerDetails = customerDetails;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
  }

  public void markOrderComplete() {
    this.state = COMPLETED;
  }
}

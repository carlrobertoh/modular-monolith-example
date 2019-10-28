package ee.carlr.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ee.carlr.order.OrderState.COMPLETED;
import static ee.carlr.order.OrderState.OPEN;

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

  public Long getId() {
    return id;
  }

  public List<OrderItem> getOrderItems() {
    return Collections.unmodifiableList(orderItems);
  }

  public Object getCustomerDetails() {
    return customerDetails;
  }

  public OrderState getState() {
    return state;
  }
}

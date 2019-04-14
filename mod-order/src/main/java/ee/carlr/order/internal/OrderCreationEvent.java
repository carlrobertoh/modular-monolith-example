package ee.carlr.order.internal;

import org.springframework.context.ApplicationEvent;

public class OrderCreationEvent extends ApplicationEvent {
  OrderCreationEvent(Object source) {
    super(source);
  }

  public Order getOrder() {
    return (Order) getSource();
  }
}

package ee.carlr.order;

import org.springframework.context.ApplicationEvent;

public class OrderCreationEvent extends ApplicationEvent {

  OrderCreationEvent(Order source) {
    super(source);
  }

  public Order getOrder() {
    return (Order) getSource();
  }
}

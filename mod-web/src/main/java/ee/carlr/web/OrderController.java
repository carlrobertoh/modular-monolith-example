package ee.carlr.web;

import ee.carlr.order.Order;
import ee.carlr.order.OrderComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/order")
class OrderController {

  private final OrderComponent orderComponent;

  OrderController(OrderComponent orderComponent) {
    this.orderComponent = orderComponent;
  }

  @GetMapping(value = "/{orderId}")
  ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
    return new ResponseEntity<>(orderComponent.getOrder(orderId), OK);
  }
}

package ee.carlr.web;

import ee.carlr.order.OrderComponent;
import ee.carlr.order.internal.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
class OrderController {
  private final OrderComponent orderComponent;

  @GetMapping(value = "/{orderId}")
  ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
    return new ResponseEntity<>(orderComponent.getOrder(orderId), OK);
  }
}

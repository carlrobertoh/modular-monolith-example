package ee.carlr.web;

import ee.carlr.order.Order;
import ee.carlr.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/order")
class OrderController {

  private final OrderService orderService;

  OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping(value = "/{orderId}")
  ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
    return new ResponseEntity<>(orderService.getOrder(orderId), OK);
  }
}

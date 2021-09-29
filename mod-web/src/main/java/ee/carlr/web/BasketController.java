package ee.carlr.web;

import ee.carlr.basket.Basket;
import ee.carlr.basket.BasketService;
import ee.carlr.order.OrderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/basket")
class BasketController {

  private final BasketService basketService;
  private final OrderService orderService;

  BasketController(BasketService basketService, OrderService orderService) {
    this.basketService = basketService;
    this.orderService = orderService;
  }

  @GetMapping("/{basketId}")
  ResponseEntity<Basket> getBasket(@PathVariable Long basketId) {
    return new ResponseEntity<>(basketService.getBasket(basketId), OK);
  }

  @PostMapping
  ResponseEntity<Void> createBasket(@RequestBody Object customerDetails) {
    Basket basket = basketService.createBasket(customerDetails);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(linkTo(BasketController.class).slash(basket.getBasketId()).toUri());
    return new ResponseEntity<>(headers, CREATED);
  }

  @PostMapping("/confirm")
  ResponseEntity<Void> confirmBasket(@RequestParam Long basketId) {
    Basket basket = basketService.getBasket(basketId);
    basketService.confirmBasket(basket);

    HttpHeaders headers = new HttpHeaders();
    Long orderId = orderService.createOrder(basket).getId();
    headers.setLocation(linkTo(OrderController.class).slash(orderId).toUri());
    return new ResponseEntity<>(headers, CREATED);
  }

  @PutMapping("/add")
  ResponseEntity<Void> addProduct(@RequestParam Long basketId,
                                  @RequestParam Long productId) {
    basketService.addProduct(basketId, productId);
    return new ResponseEntity<>(OK);
  }
}

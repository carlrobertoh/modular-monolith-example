package ee.carlr.web;

import ee.carlr.basket.Basket;
import ee.carlr.basket.BasketComponent;
import ee.carlr.order.OrderComponent;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/basket")
class BasketController {

  private final BasketComponent basketComponent;
  private final OrderComponent orderComponent;

  BasketController(BasketComponent basketComponent, OrderComponent orderComponent) {
    this.basketComponent = basketComponent;
    this.orderComponent = orderComponent;
  }

  @GetMapping("/{basketId}")
  ResponseEntity<Basket> getBasket(@PathVariable Long basketId) {
    return new ResponseEntity<>(basketComponent.getBasket(basketId), OK);
  }

  @PostMapping
  ResponseEntity<Void> createBasket(@RequestBody Object customerDetails) {
    Basket basket = basketComponent.createBasket(customerDetails);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(linkTo(BasketController.class).slash(basket.getBasketId()).toUri());
    return new ResponseEntity<>(headers, CREATED);
  }

  @PostMapping("/confirm")
  ResponseEntity<Void> confirmBasket(@RequestParam Long basketId) {
    Basket basket = basketComponent.getBasket(basketId);
    basketComponent.confirmBasket(basket);

    HttpHeaders headers = new HttpHeaders();
    Long orderId = orderComponent.createOrder(basket).getId();
    headers.setLocation(linkTo(OrderController.class).slash(orderId).toUri());
    return new ResponseEntity<>(headers, CREATED);
  }

  @PutMapping("/add")
  ResponseEntity<Void> addProduct(@RequestParam Long basketId,
                                  @RequestParam Long productId) {
    basketComponent.addProduct(basketId, productId);
    return new ResponseEntity<>(OK);
  }
}

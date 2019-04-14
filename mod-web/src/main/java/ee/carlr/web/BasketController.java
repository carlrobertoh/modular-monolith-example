package ee.carlr.web;

import ee.carlr.basket.BasketComponent;
import ee.carlr.basket.internal.Basket;
import ee.carlr.order.OrderComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
class BasketController {
  private final BasketComponent basketComponent;
  private final OrderComponent orderComponent;

  @GetMapping(value = "/{basketId}")
  ResponseEntity<Basket> getStatement(@PathVariable Long basketId) {
    return new ResponseEntity<>(basketComponent.getBasket(basketId), OK);
  }

  @PostMapping
  ResponseEntity<Void> createBasket(@RequestBody Object customerDetails) {
    Basket basket = basketComponent.createBasket(customerDetails);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(linkTo(BasketController.class).slash(basket.getBasketId()).toUri());
    return new ResponseEntity<>(headers, CREATED);
  }

  @PostMapping(value = "/confirm")
  ResponseEntity<Void> confirmBasket(@RequestParam Long basketId) {
    Basket basket = basketComponent.getBasket(basketId);
    basketComponent.confirmBasket(basket);

    HttpHeaders headers = new HttpHeaders();
    Long orderId = orderComponent.createOrder(basket).getId();
    headers.setLocation(linkTo(OrderController.class).slash(orderId).toUri());
    return new ResponseEntity<>(headers, CREATED);
  }

  @PutMapping(value = "/add")
  ResponseEntity<Void> addProduct(@RequestParam Long basketId,
                                  @RequestParam Long productId) {
    basketComponent.addProduct(basketId, productId);
    return new ResponseEntity<>(OK);
  }
}

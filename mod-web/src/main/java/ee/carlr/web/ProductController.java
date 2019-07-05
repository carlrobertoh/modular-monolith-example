package ee.carlr.web;

import ee.carlr.product.ProductComponent;
import ee.carlr.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
class ProductController {
  private final ProductComponent productComponent;

  @GetMapping(value = "/getAll")
  ResponseEntity<List<Product>> getAllProducts() {
    return new ResponseEntity<>(productComponent.getAllProducts(), OK);
  }
}

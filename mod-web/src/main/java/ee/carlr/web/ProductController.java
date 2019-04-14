package ee.carlr.web;

import ee.carlr.product.ProductComponent;
import ee.carlr.product.internal.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
class ProductController {
  private final ProductComponent productComponent;

  @GetMapping(value = "/getAll")
  List<Product> getAllProducts() {
    return productComponent.getAllProducts();
  }
}

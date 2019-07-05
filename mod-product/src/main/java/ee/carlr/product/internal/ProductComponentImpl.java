package ee.carlr.product.internal;

import ee.carlr.product.Product;
import ee.carlr.product.ProductComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class ProductComponentImpl implements ProductComponent {
  private final ProductRepository productRepository;

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAllProducts();
  }

  @Override
  public Product getProduct(Long productId) {
    return productRepository.findProduct(productId);
  }
}

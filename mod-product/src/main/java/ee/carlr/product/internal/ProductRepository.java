package ee.carlr.product.internal;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class ProductRepository {
  List<Product> findAllProducts() {
    throw new UnsupportedOperationException();
  }

  Product findProduct(Long productId) {
    throw new UnsupportedOperationException();
  }
}
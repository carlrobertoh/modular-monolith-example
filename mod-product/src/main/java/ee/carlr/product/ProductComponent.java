package ee.carlr.product;

import ee.carlr.product.internal.Product;

import java.util.List;

public interface ProductComponent {
  List<Product> getAllProducts();

  Product getProduct(Long productId);
}

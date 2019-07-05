package ee.carlr.product;

import java.util.List;

public interface ProductComponent {
  List<Product> getAllProducts();

  Product getProduct(Long productId);
}

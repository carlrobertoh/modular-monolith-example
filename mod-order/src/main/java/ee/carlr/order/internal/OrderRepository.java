package ee.carlr.order.internal;

import ee.carlr.order.Order;
import org.springframework.stereotype.Repository;

@Repository
class OrderRepository {
  Order saveOrder(Order order) {
    throw new UnsupportedOperationException();
  }

  Order getOrder(Long orderId) {
    throw new UnsupportedOperationException();
  }

  void updateOrder(Order order) {
    throw new UnsupportedOperationException();
  }
}

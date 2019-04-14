package ee.carlr.billing.internal;

import org.springframework.stereotype.Repository;

@Repository
class BillingRepository {
  void saveInvoice(Invoice invoice) {
    throw new UnsupportedOperationException();
  }

  Invoice getInvoice(Long invoiceId) {
    throw new UnsupportedOperationException();
  }

  Invoice getInvoiceByOrderId(Long orderId) {
    throw new UnsupportedOperationException();
  }

  void updateInvoice(Invoice invoice) {
    throw new UnsupportedOperationException();
  }
}

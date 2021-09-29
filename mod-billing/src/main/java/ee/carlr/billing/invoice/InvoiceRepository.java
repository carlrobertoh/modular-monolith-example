package ee.carlr.billing.invoice;

import org.springframework.stereotype.Repository;

@Repository
class InvoiceRepository {

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

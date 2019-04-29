package ee.carlr.billing;

import ee.carlr.billing.internal.invoice.Invoice;

public interface InvoiceComponent {
  Invoice getInvoice(Long invoiceId);

  Invoice getInvoiceByOrderId(Long orderId);

  void updateInvoice(Invoice invoice);
}

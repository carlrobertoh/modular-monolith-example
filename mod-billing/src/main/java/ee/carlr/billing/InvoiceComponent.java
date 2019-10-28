package ee.carlr.billing;

public interface InvoiceComponent {

  Invoice getInvoice(Long invoiceId);

  Invoice getInvoiceByOrderId(Long orderId);

  void updateInvoice(Invoice invoice);
}

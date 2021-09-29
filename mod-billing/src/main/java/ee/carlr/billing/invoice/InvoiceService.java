package ee.carlr.billing.invoice;

public interface InvoiceService {

  Invoice getInvoice(Long invoiceId);

  Invoice getInvoiceByOrderId(Long orderId);

  void updateInvoice(Invoice invoice);
}

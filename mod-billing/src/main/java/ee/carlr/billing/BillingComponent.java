package ee.carlr.billing;

import ee.carlr.billing.internal.Invoice;
import ee.carlr.billing.internal.PaymentResponse;

public interface BillingComponent {
  Invoice getInvoice(Long invoiceId);

  Invoice getInvoiceByOrderId(Long orderId);

  void processPayment(PaymentResponse paymentResponse);
}

package ee.carlr.billing.internal.payment;

import ee.carlr.billing.InvoiceComponent;
import ee.carlr.billing.PaymentComponent;
import ee.carlr.billing.internal.invoice.Invoice;
import ee.carlr.order.OrderComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PaymentComponentImpl implements PaymentComponent {
  private final OrderComponent orderComponent;
  private final InvoiceComponent invoiceComponent;

  @Override
  public void processPayment(PaymentResponse paymentResponse) {
    if (paymentResponse.isPaymentSuccess()) {
      Invoice invoice = invoiceComponent.getInvoice(paymentResponse.getInvoiceId());
      acceptInvoice(invoice);
      orderComponent.completeOrder(invoice.getOrder().getId());
    }
  }

  private void acceptInvoice(Invoice invoice) {
    invoice.markInvoicePaid();
    invoiceComponent.updateInvoice(invoice);
  }
}

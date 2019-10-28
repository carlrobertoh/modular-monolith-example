package ee.carlr.billing.internal.payment;

import ee.carlr.billing.Invoice;
import ee.carlr.billing.InvoiceComponent;
import ee.carlr.billing.PaymentComponent;
import ee.carlr.billing.PaymentResponse;
import ee.carlr.order.OrderComponent;
import org.springframework.stereotype.Component;

@Component
class PaymentComponentImpl implements PaymentComponent {

  private final OrderComponent orderComponent;
  private final InvoiceComponent invoiceComponent;

  PaymentComponentImpl(OrderComponent orderComponent, InvoiceComponent invoiceComponent) {
    this.orderComponent = orderComponent;
    this.invoiceComponent = invoiceComponent;
  }

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

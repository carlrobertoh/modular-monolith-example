package ee.carlr.billing.payment;

import ee.carlr.billing.invoice.Invoice;
import ee.carlr.billing.invoice.InvoiceService;
import ee.carlr.order.OrderService;
import org.springframework.stereotype.Component;

@Component
class PaymentServiceImpl implements PaymentService {

  private final OrderService orderService;
  private final InvoiceService invoiceService;

  PaymentServiceImpl(OrderService orderService, InvoiceService invoiceService) {
    this.orderService = orderService;
    this.invoiceService = invoiceService;
  }

  @Override
  public void processPayment(PaymentResponse paymentResponse) {
    if (paymentResponse.isPaymentSuccess()) {
      Invoice invoice = invoiceService.getInvoice(paymentResponse.getInvoiceId());
      acceptInvoice(invoice);
      orderService.completeOrder(invoice.getOrder().getId());
    }
  }

  private void acceptInvoice(Invoice invoice) {
    invoice.markInvoicePaid();
    invoiceService.updateInvoice(invoice);
  }
}

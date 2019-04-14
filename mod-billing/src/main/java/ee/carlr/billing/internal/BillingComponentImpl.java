package ee.carlr.billing.internal;

import ee.carlr.billing.BillingComponent;
import ee.carlr.order.OrderComponent;
import ee.carlr.order.internal.Order;
import ee.carlr.order.internal.OrderCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class BillingComponentImpl implements BillingComponent {
  private final BillingRepository billingRepository;
  private final OrderComponent orderComponent;

  @EventListener
  public void generateInvoice(OrderCreationEvent event) {
    billingRepository.saveInvoice(new Invoice(event.getOrder()));
  }

  @Override
  public Invoice getInvoice(Long invoiceId) {
    return billingRepository.getInvoice(invoiceId);
  }

  @Override
  public Invoice getInvoiceByOrderId(Long orderId) {
    return billingRepository.getInvoiceByOrderId(orderId);
  }

  @Override
  public void processPayment(PaymentResponse paymentResponse) {
    if (paymentResponse.isPaymentSuccess()) {
      Invoice invoice = getInvoice(paymentResponse.getInvoiceId());
      invoice.markInvoicePaid();
      updateInvoice(invoice);

      Order order = orderComponent.getOrder(invoice.getOrderId());
      order.markOrderAccepted();
      orderComponent.updateOrder(order);
    }
  }

  private void updateInvoice(Invoice invoice) {
    billingRepository.updateInvoice(invoice);
  }
}

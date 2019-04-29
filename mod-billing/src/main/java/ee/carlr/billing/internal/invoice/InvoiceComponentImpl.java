package ee.carlr.billing.internal.invoice;

import ee.carlr.billing.InvoiceComponent;
import ee.carlr.order.internal.OrderCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class InvoiceComponentImpl implements InvoiceComponent {
  private final InvoiceRepository invoiceRepository;

  @EventListener
  public void generateInvoice(OrderCreationEvent event) {
    invoiceRepository.saveInvoice(new Invoice(event.getOrder()));
  }

  @Override
  public Invoice getInvoice(Long invoiceId) {
    return invoiceRepository.getInvoice(invoiceId);
  }

  @Override
  public Invoice getInvoiceByOrderId(Long orderId) {
    return invoiceRepository.getInvoiceByOrderId(orderId);
  }

  @Override
  public void updateInvoice(Invoice invoice) {
    invoiceRepository.updateInvoice(invoice);
  }
}

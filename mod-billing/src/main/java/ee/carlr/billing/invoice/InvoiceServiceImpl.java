package ee.carlr.billing.invoice;

import ee.carlr.order.OrderCreationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class InvoiceServiceImpl implements InvoiceService {

  private final InvoiceRepository invoiceRepository;

  InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
    this.invoiceRepository = invoiceRepository;
  }

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

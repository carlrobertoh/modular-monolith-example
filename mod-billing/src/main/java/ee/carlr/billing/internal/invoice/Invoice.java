package ee.carlr.billing.internal.invoice;

import ee.carlr.order.internal.Order;
import ee.carlr.order.internal.OrderItem;
import lombok.Getter;

import static ee.carlr.billing.internal.invoice.InvoiceStatus.PAID;
import static ee.carlr.billing.internal.invoice.InvoiceStatus.UNPAID;

@Getter
public class Invoice {
  private Long id;
  private Order order;
  private Object customerDetails;
  private InvoiceStatus status;

  Invoice(Order order) {
    this.status = UNPAID;
    this.order = order;
    this.customerDetails = order.getCustomerDetails();
  }

  public void markInvoicePaid() {
    this.status = PAID;
  }

  void setId(Long id) {
    this.id = id;
  }

  public Double getTotalAmount() {
    return order.getOrderItems().stream().mapToDouble(OrderItem::getPrice).sum();
  }
}

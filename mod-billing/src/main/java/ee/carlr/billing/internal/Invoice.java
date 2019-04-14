package ee.carlr.billing.internal;

import ee.carlr.order.internal.Order;
import ee.carlr.order.internal.OrderItem;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

import static ee.carlr.billing.internal.InvoiceStatus.PAID;
import static ee.carlr.billing.internal.InvoiceStatus.UNPAID;

@Getter
public class Invoice {
  private Long id;
  private Long invoiceNumber;
  private Long orderId;
  private List<OrderItem> orderItems;
  private Object customerDetails;
  private InvoiceStatus status;

  Invoice(Order order) {
    this.status = UNPAID;
    this.orderId = order.getId();
    this.customerDetails = order.getCustomerDetails();
    this.orderItems = order.getOrderItems();
  }

  void markInvoicePaid() {
    this.status = PAID;
  }

  void setId(Long id) {
    this.id = id;
  }

  void setInvoiceNumber(Long invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public BigDecimal getTotalAmount() {
    // TODO: return orderItems.stream().mapToDouble(OrderItem::getAmount).sum();
    return BigDecimal.valueOf(0.0);
  }
}

package ee.carlr.billing;

import ee.carlr.order.Order;
import ee.carlr.order.OrderItem;
import lombok.Getter;

import static ee.carlr.billing.InvoiceStatus.*;

@Getter
public class Invoice {
  private Long id;
  private Order order;
  private Object customerDetails;
  private InvoiceStatus status;

  public Invoice(Order order) {
    this.status = UNPAID;
    this.order = order;
    this.customerDetails = order.getCustomerDetails();
  }

  void setId(Long id) {
    this.id = id;
  }

  public void markInvoicePaid() {
    this.status = PAID;
  }

  public Double getTotalAmount() {
    return order.getOrderItems().stream().mapToDouble(OrderItem::getPrice).sum();
  }
}

package ee.carlr.billing;

import ee.carlr.order.Order;
import ee.carlr.order.OrderItem;

import static ee.carlr.billing.InvoiceStatus.PAID;
import static ee.carlr.billing.InvoiceStatus.UNPAID;

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
    return order.getOrderItems().stream()
            .mapToDouble(OrderItem::getPrice)
            .sum();
  }

  public Long getId() {
    return id;
  }

  public Order getOrder() {
    return order;
  }

  public Object getCustomerDetails() {
    return customerDetails;
  }

  public InvoiceStatus getStatus() {
    return status;
  }
}

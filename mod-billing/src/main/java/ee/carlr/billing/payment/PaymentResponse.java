package ee.carlr.billing.payment;

public class PaymentResponse {

  private final boolean isPaymentSuccess;
  private final Long invoiceId;

  public PaymentResponse(boolean isPaymentSuccess, Long invoiceId) {
    this.isPaymentSuccess = isPaymentSuccess;
    this.invoiceId = invoiceId;
  }

  public boolean isPaymentSuccess() {
    return isPaymentSuccess;
  }

  public Long getInvoiceId() {
    return invoiceId;
  }
}

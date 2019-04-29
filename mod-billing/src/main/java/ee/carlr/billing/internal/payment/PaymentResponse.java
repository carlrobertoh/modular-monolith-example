package ee.carlr.billing.internal.payment;

import lombok.Value;

@Value
public class PaymentResponse {
  private boolean isPaymentSuccess;
  private Long invoiceId;
}

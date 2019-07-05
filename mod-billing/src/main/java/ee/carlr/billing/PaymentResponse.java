package ee.carlr.billing;

import lombok.Value;

@Value
public class PaymentResponse {
  private boolean isPaymentSuccess;
  private Long invoiceId;
}

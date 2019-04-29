package ee.carlr.billing;

import ee.carlr.billing.internal.payment.PaymentResponse;

public interface PaymentComponent {
  void processPayment(PaymentResponse paymentResponse);
}

package ee.carlr.billing;

public interface PaymentComponent {

  void processPayment(PaymentResponse paymentResponse);
}

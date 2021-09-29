package ee.carlr.billing.payment;

public interface PaymentService {

  void processPayment(PaymentResponse paymentResponse);
}

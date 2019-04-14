package ee.carlr.web;

import ee.carlr.billing.BillingComponent;
import ee.carlr.billing.internal.Invoice;
import ee.carlr.billing.internal.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/billing")
class BillingController {
  private final BillingComponent billingComponent;

  @PostMapping(value = "/processPayment")
  public ResponseEntity<Void> processPayment(@RequestBody PaymentResponse paymentResponse) {
    billingComponent.processPayment(paymentResponse);
    return new ResponseEntity<>(OK);
  }

  @GetMapping(value = "/invoice")
  ResponseEntity<Invoice> getInvoice(@RequestParam Long orderId) {
    return new ResponseEntity<>(billingComponent.getInvoiceByOrderId(orderId), OK);
  }
}

package ee.carlr.web;

import ee.carlr.billing.Invoice;
import ee.carlr.billing.InvoiceComponent;
import ee.carlr.billing.PaymentComponent;
import ee.carlr.billing.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/billing")
class BillingController {

  private final InvoiceComponent invoiceComponent;
  private final PaymentComponent paymentComponent;

  BillingController(InvoiceComponent invoiceComponent, PaymentComponent paymentComponent) {
    this.invoiceComponent = invoiceComponent;
    this.paymentComponent = paymentComponent;
  }

  @PostMapping(value = "/processPayment")
  ResponseEntity<Void> processPayment(@RequestBody PaymentResponse paymentResponse) {
    paymentComponent.processPayment(paymentResponse);
    return new ResponseEntity<>(OK);
  }

  @GetMapping(value = "/invoice")
  ResponseEntity<Invoice> getInvoice(@RequestParam Long orderId) {
    return new ResponseEntity<>(invoiceComponent.getInvoiceByOrderId(orderId), OK);
  }
}

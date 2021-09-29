package ee.carlr.web;

import ee.carlr.billing.invoice.Invoice;
import ee.carlr.billing.invoice.InvoiceService;
import ee.carlr.billing.payment.PaymentService;
import ee.carlr.billing.payment.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/billing")
class BillingController {

  private final InvoiceService invoiceService;
  private final PaymentService paymentService;

  BillingController(InvoiceService invoiceService, PaymentService paymentService) {
    this.invoiceService = invoiceService;
    this.paymentService = paymentService;
  }

  @PostMapping(value = "/processPayment")
  ResponseEntity<Void> processPayment(@RequestBody PaymentResponse paymentResponse) {
    paymentService.processPayment(paymentResponse);
    return new ResponseEntity<>(OK);
  }

  @GetMapping(value = "/invoice")
  ResponseEntity<Invoice> getInvoice(@RequestParam Long orderId) {
    return new ResponseEntity<>(invoiceService.getInvoiceByOrderId(orderId), OK);
  }
}

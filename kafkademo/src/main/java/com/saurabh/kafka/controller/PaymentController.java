package com.saurabh.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saurabh.kafka.model.PaymentRequest;
import com.saurabh.kafka.service.TransactionalPaymentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final TransactionalPaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> initiatePayment(@Valid @RequestBody PaymentRequest req) {
        String paymentId = paymentService.processPayment(req);
        return ResponseEntity.accepted().body(paymentId);
    }

}

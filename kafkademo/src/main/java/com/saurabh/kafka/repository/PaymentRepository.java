package com.saurabh.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.kafka.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}

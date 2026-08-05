package com.saurabh.kafka.repository;

import com.saurabh.kafka.model.AuditEntry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditEntry, String> {

}

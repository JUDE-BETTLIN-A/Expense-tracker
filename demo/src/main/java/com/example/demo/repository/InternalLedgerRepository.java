package com.example.demo.repository;

import com.example.demo.entity.InternalLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalLedgerRepository extends JpaRepository<InternalLedger, String> {}

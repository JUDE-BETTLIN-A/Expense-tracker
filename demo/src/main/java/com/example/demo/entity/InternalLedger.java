package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "internal_ledger")
@Data
public class InternalLedger {

    @Id
    private String id;

    private String account;
    private BigDecimal debit;
    private BigDecimal credit;
    private String currency;
    private LocalDate transactionDate;
    private String referenceId;

    private LocalDateTime createdAt;
}

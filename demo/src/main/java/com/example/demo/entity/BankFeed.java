package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_feed")
@Data
public class BankFeed {

    @Id
    private String id;

    private String source;
    private String description;

    private BigDecimal debit;
    private BigDecimal credit;

    private String currency;
    private LocalDate transactionDate;
    private String referenceId;

    private String matchedLedgerId;
    private String matchType;
    private Integer confidenceScore;

    private LocalDateTime createdAt;
}


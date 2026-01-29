Expense Tracker

Expense Tracker is a backend project that automatically reconciles bank transactions with internal financial records.
It helps remove manual Excel-based reconciliation by matching transactions programmatically and flagging mismatches.

What This Project Does

Accepts bank transaction data (CSV / API)

Stores internal financial records

Matches bank data with internal ledger entries

Identifies:

Exact matches

Minor differences (fees, delays)

Missing or unmatched transactions

Keeps an audit log of all actions

Why This Project

In real companies, bank statements and internal records rarely match exactly.
LedgerFlow simulates how finance systems solve this problem using automation instead of manual work.

Tech Stack

Java

Spring Boot

MySQL

REST APIs

Maven

Key Concepts Used

Double-entry accounting

Data normalization

Transaction reconciliation

ACID database transactions

Audit logging

Financial precision using DECIMAL

Project Status

🚧 In Progress
Currently implementing ingestion, ledger, and reconciliation logic.

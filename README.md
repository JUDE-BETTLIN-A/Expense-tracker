Expense Tracker

Expense Tracker is a backend-focused financial reconciliation system that automatically matches bank transactions with internal ledger records and flags discrepancies for review.

Getting Started
Prerequisites

Java 17+

Maven

MySQL

Setup

Clone the repository:

git clone https://github.com/your-username/ledgerflow.git
cd ledgerflow


Configure MySQL in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/ledgerflow
spring.datasource.username=root
spring.datasource.password=your_password


Create the database:

CREATE DATABASE ledgerflow;


Run the application:

mvn spring-boot:run


The backend will start at
👉 http://localhost:8080

Project Structure

ingestion – Handles CSV / API input and normalizes data

ledger – Stores internal financial records (immutable)

reconciliation – Matches bank data with internal ledger

audit – Tracks all user and system actions

Features

Transaction ingestion from bank feeds

Data normalization (date, currency, formats)

Exact and fuzzy matching logic

Discrepancy detection

Audit trail for compliance

Learn More

Spring Boot Documentation: https://spring.io/projects/spring-boot

MySQL Documentation: https://dev.mysql.com/doc/

Deployment

You can deploy this application using:

Docker

AWS EC2

Render / Railway

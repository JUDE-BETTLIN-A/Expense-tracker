package com.example.demo.repository;

import com.example.demo.entity.BankFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankFeedRepository extends JpaRepository<BankFeed, String> {}

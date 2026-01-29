package com.example.demo.controller;

import com.example.demo.entity.BankFeed;
import com.example.demo.repository.BankFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bank")
public class BankFeedController {

    @Autowired
    private BankFeedRepository repository;

    @PostMapping("/upload")
    public String uploadBankCSV(@RequestParam("file") MultipartFile file) throws Exception {

        List<String> lines = new BufferedReader(
                new InputStreamReader(file.getInputStream()))
                .lines()
                .skip(1)
                .toList();

        for (String line : lines) {
            String[] data = line.split(",");

            BankFeed bf = new BankFeed();
            bf.setId(UUID.randomUUID().toString());
            bf.setSource(data[0]);
            bf.setDebit(new BigDecimal(data[1]));
            bf.setCurrency(data[2]);
            bf.setTransactionDate(LocalDate.parse(data[3]));
            bf.setReferenceId(data[4]);
            bf.setDescription(data[5]);
            bf.setCreatedAt(LocalDateTime.now());

            repository.save(bf);
        }

        return "Bank CSV uploaded successfully";
    }
}

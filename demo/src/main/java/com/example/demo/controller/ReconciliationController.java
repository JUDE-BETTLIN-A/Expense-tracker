package com.example.demo.controller;

import com.example.demo.sevice.ReconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reconcile")
public class ReconciliationController {

    @Autowired
    private ReconciliationService service;

    @PostMapping
    public String reconcile() {
        service.reconcile();
        return "Reconciliation completed";
    }
}

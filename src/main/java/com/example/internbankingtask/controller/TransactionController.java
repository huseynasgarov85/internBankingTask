package com.example.internbankingtask.controller;

import com.example.internbankingtask.service.transaction.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class Transaction {

    private final TransactionService transactionService;

    @PostMapping("transform/money")
    @Operation(summary = "this endpoint sweep money one user to another user", description = "this api transformed money")
    public ResponseEntity<?> changeMoney() {
        return null;
    }
}

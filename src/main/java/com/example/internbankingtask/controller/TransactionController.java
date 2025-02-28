package com.example.internbankingtask.controller;

import com.example.internbankingtask.model.payload.TransactionPayload;
import com.example.internbankingtask.service.transaction.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PatchMapping("/payment")
    @Operation(summary = "this api is used for users to benefit utility payments")
    public void payment(@RequestBody TransactionPayload transactionPayload) {
        transactionService.payment(transactionPayload);
    }

}

package com.example.internbankingtask.service.transaction;

import com.example.internbankingtask.model.payload.TransactionPayload;

public interface TransactionService {
    void payment(TransactionPayload transactionPayload);
}

package com.example.internbankingtask.mapper;

import com.example.internbankingtask.model.entity.postgre.Transaction;
import com.example.internbankingtask.model.payload.TransactionPayload;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction mapToEntity(TransactionPayload transactionPayload) {
        return Transaction
                .builder()
                .id(transactionPayload.getId())
                .type(transactionPayload.getType())
                .amount(transactionPayload.getAmount())
                .time(transactionPayload.getTime())
                .userId(transactionPayload.getUserId())
                .utility(transactionPayload.getUtility())
                .build();
    }

}

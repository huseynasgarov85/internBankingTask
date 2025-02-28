package com.example.internbankingtask.service.transaction;

import com.example.internbankingtask.mapper.TransactionMapper;
import com.example.internbankingtask.model.entity.postgre.Transaction;
import com.example.internbankingtask.model.payload.TransactionPayload;
import com.example.internbankingtask.model.repo.postgre.TransactionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;
    private final TransactionMapper transactionMapper;

    @Override
    public void payment(TransactionPayload transactionPayload) {
        log.info("ActionLog started payment " + transactionPayload.getUserId() + "-" + transactionPayload.getId());
        Transaction transaction = transactionMapper.mapToEntity(transactionPayload);
        transactionRepo.save(transaction);
        log.info("ActionLog end payment " + transactionPayload.getUserId() + "-" + transactionPayload.getId());
    }
}

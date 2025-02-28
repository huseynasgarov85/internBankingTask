package com.example.internbankingtask.model.repo.postgre;

import com.example.internbankingtask.model.entity.postgre.Transaction;
import com.example.internbankingtask.model.payload.TransactionPayload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}

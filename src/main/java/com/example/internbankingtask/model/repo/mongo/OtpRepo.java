package com.example.internbankingtask.model.repo.mongo;

import com.example.internbankingtask.model.entity.mongo.Otp;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OtpRepo extends MongoRepository<Otp, String> {
    Optional<Otp> findOtpByEmail(String email);
}

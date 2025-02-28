package com.example.internbankingtask.service.otp;

import com.example.internbankingtask.model.entity.mongo.Otp;

public interface OtpService {

    void otpSave(Otp otp);

    Otp findOtpByEmail(String email);
}

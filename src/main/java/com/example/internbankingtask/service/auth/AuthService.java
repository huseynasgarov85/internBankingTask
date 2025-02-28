package com.example.internbankingtask.service.auth;

import com.example.internbankingtask.model.payload.OtpPayload;
import com.example.internbankingtask.model.payload.RegisterPayload;
import com.example.internbankingtask.model.response.RegisterResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    RegisterResponse register(RegisterPayload registerPayload);

    ResponseEntity<?> verifyOtp(OtpPayload otpPayload);
}

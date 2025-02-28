package com.example.internbankingtask.controller;

import com.example.internbankingtask.model.payload.OtpPayload;
import com.example.internbankingtask.model.payload.RegisterPayload;
import com.example.internbankingtask.model.response.RegisterResponse;
import com.example.internbankingtask.service.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class Auth {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(description = "this api  used for user register", summary = "this api used for save user to db")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody @Valid RegisterPayload registerPayload) {
        return authService.register(registerPayload);
    }

    @PostMapping("/verifyOtp")
    @Operation(description = "This api used for user confirm otp", summary = "this api after sending user otp code to verify")
    public ResponseEntity<?> verifyOtp(@RequestBody @Valid OtpPayload otpPayload) {
        return authService.verifyOtp(otpPayload);
    }
}

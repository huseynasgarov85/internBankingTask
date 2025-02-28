package com.example.internbankingtask.util.otp;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpUtil {
    public String generateOtp() {
        Random random = new Random();
        int number = random.nextInt(100000, 1000000);
        return Integer.toString(number);
    }
}

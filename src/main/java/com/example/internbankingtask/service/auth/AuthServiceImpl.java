package com.example.internbankingtask.service.auth;

import com.example.internbankingtask.globalExceptionHandler.exceptions.EmailAlreadyExists;
import com.example.internbankingtask.globalExceptionHandler.exceptions.InvalidOtp;
import com.example.internbankingtask.model.entity.mongo.Otp;
import com.example.internbankingtask.model.entity.postgre.User;
import com.example.internbankingtask.model.payload.OtpPayload;
import com.example.internbankingtask.model.payload.RegisterPayload;
import com.example.internbankingtask.model.response.RegisterResponse;
import com.example.internbankingtask.service.otp.OtpService;
import com.example.internbankingtask.service.user.UserService;
import com.example.internbankingtask.service.user.UserServiceImpl;
import com.example.internbankingtask.util.email.EmailUtil;
import com.example.internbankingtask.util.otp.OtpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final OtpUtil otpUtil;
    private final ObjectMapper objectMapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final EmailUtil emailUtil;
    private final OtpService otpService;

    @Override
    public RegisterResponse register(RegisterPayload registerPayload) {
        log.info("ActionLog started register " + registerPayload.getEmail());
        if (userService.checkEmail(registerPayload.getEmail())) {
            throw new EmailAlreadyExists("Email already registered");
        }
        User user = objectMapper.convertValue(registerPayload, User.class);
        user.setPassword(passwordEncoder.encode(registerPayload.getPassword()));
        user.setActive(false);
        String otp = otpUtil.generateOtp();
        Otp otp1 = new Otp(otp, LocalDateTime.now(), user.getEmail());
        emailUtil.sendToUserOtp(otp, user.getEmail());
        otpService.otpSave(otp1);
        log.info("ActionLog end register " + registerPayload.getEmail());
        return objectMapper.convertValue(userService.userSave(user), RegisterResponse.class);
    }

    @Override
    public ResponseEntity<?> verifyOtp(OtpPayload otpPayload) {
        log.info("ActionLog started verifyOtp " + otpPayload.getEmail());
        Otp otp = otpService.findOtpByEmail(otpPayload.getEmail());
        Duration duration = Duration.between(otp.getCreatedAt(), LocalDateTime.now());
        if (Objects.equals(otp.getOtp(), otpPayload.getOtp()) && duration.toMinutes() <= 2) {
            User user = userService.findUserByEmail(otp.getEmail());
            user.setActive(true);
            userService.userSave(user);
        } else {
            throw new InvalidOtp("otp is invalid");
        }
        log.info("ActionLog end verifyOtp " + otpPayload.getEmail());
        return ResponseEntity.noContent().build();
    }
}

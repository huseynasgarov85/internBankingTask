package com.example.internbankingtask.service.otp;

import com.example.internbankingtask.globalExceptionHandler.exceptions.NotFoundException;
import com.example.internbankingtask.model.entity.mongo.Otp;
import com.example.internbankingtask.model.repo.mongo.OtpRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtpServiceImpl implements OtpService {
    private final OtpRepo otpRepo;

    @Override
    public void otpSave(Otp otp) {
        log.info("ActionLog started otpSave " + otp);
        otpRepo.save(otp);
        log.info("ActionLog end otpSave" + otp);
    }

    @Override
    public Otp findOtpByEmail(String email) {
        return otpRepo.findOtpByEmail(email).orElseThrow(() -> new NotFoundException("otp not founded"));
    }
}

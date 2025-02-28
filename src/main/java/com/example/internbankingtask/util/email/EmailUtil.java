package com.example.internbankingtask.util.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailUtil {
    private final JavaMailSender javaMailSender;

    public void sendToUserOtp(String otp, String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Otp verification");
            mimeMessageHelper.setText("otp code :" + otp);
        } catch (MessagingException e) {
            log.error("ActionLog error " + e.getMessage());
            throw new RuntimeException("unexpected error occurred");
        }
        javaMailSender.send(mimeMessage);
    }

}

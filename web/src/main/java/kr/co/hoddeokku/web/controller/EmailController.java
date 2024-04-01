package kr.co.hoddeokku.web.controller;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final JavaMailSender emailSender;

    public EmailController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping("/sendVerificationEmail")
    public void sendVerificationEmail(@RequestBody EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        
        //난수생성
        String strRan = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(strRan.length());
            sb.append(strRan.charAt(index));
        }

        message.setTo(emailRequest.getEmail());
        message.setSubject("Hodduk 이메일 인증 코드");
        message.setText("인증 코드: " + sb.toString()); // 실제로는 랜덤한 인증 코드를 생성하여 여기에 넣어야 합니다.
        emailSender.send(message);
    }

    static class EmailRequest {
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}

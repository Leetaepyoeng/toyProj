// package kr.co.hoddeokku.web.config;

// import java.util.Properties;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.JavaMailSenderImpl;

// @Configuration
// public class MailConfig {

//     @Bean
//     public JavaMailSender javaMailSender() {
//         JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//         mailSender.setHost("your.smtp.host");
//         mailSender.setPort(587); // SMTP 포트 번호
//         mailSender.setUsername("your.username");
//         mailSender.setPassword("your.password");

//         Properties props = mailSender.getJavaMailProperties();
//         props.put("mail.transport.protocol", "smtp");
//         props.put("mail.smtp.auth", "true");
//         props.put("mail.smtp.starttls.enable", "true");
//         props.put("mail.debug", "true"); // 디버그 모드 활성화

//         return mailSender;
//     }
// }
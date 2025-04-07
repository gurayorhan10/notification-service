package com.project.notificationservice.service;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    
    @Value("${spring.mail.username}")
    private String sender;

    public void send(String to, String title, String content, Boolean isSimple) {
        try{
            if(Boolean.TRUE.equals(isSimple)){
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(to);
                message.setSubject(title);
                message.setText(content);
                emailSender.send(message);
            }else{
                MimeMessage message = emailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
                helper.setFrom(new InternetAddress(sender, "Personel"));
                helper.setTo(to);
                helper.setSubject(title);
                helper.setText(content, true);
                emailSender.send(message);
            }
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
    }

}

package com.consultoria.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(String to, String subject, String body, String logoPathCurriculo, MultipartFile attachment) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        InputStreamSource source = new ByteArrayResource(attachment.getBytes());
        helper.addAttachment(attachment.getOriginalFilename(), source);

        // Adicionando a imagem como anexo embutido
        ClassPathResource resource = new ClassPathResource(logoPathCurriculo);
        helper.addInline("logo", resource);

        mailSender.send(message);
    }

    public void sendSimpleEmail(String to, String subject, String body, String logoPath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        // Adicionando a imagem como anexo embutido
        ClassPathResource resource = new ClassPathResource(logoPath);
        helper.addInline("logo", resource);

        mailSender.send(message);
    }
}
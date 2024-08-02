package com.consultoria.service;

import com.consultoria.model.IntegrityMessage;
import com.consultoria.repository.IntegrityMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class IntegrityMessageService {

    @Autowired
    private IntegrityMessageRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public IntegrityMessage saveMessage(IntegrityMessage message) {
        // Salvar a mensagem no banco de dados
        IntegrityMessage savedMessage = repository.save(message);

        // Enviar a mensagem por e-mail
        sendEmail(savedMessage);

        return savedMessage;
    }

    private void sendEmail(IntegrityMessage message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("bakendteste@gmail.com");
        email.setSubject("Nova Mensagem de Integridade");
        email.setText("Nova mensagem recebida:\n\n" + message.getMensagem());
        mailSender.send(email);
    }
}

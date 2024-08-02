package com.consultoria.controller;

import com.consultoria.model.IntegrityMessage;
import com.consultoria.service.EmailService;
import com.consultoria.service.IntegrityMessageService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/integrity")
public class IntegrityMessageController {

    @Autowired
    private IntegrityMessageService service;
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> saveMessage(@Valid @RequestBody IntegrityMessage message, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            String logoPath = "uploads/logo.png";
            String emailBody = "<html><body style=\"text-align: center;\">"
                    + "<img src=\"cid:logo\" alt=\"Logo da Empresa\" style=\"display: block; margin: auto;\" /><br><br>"
                    + "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 2px solid rgba(226,0,1); max-width: 600px;\">"
                    + "<h1>Canal de Integridade.</h1>"
                    + "<p><strong>Mensagem:</strong> " + message.getMensagem() + "</p>"
                    + "</table>"
                    + "</body></html>";

            emailService.sendSimpleEmail("bakendteste@gmail.com", "⚠\uFE0F Canal de integridade recebeu uma mensagem: ", emailBody, logoPath);
            return ResponseEntity.ok("{\"message\": \"Recebemos sua mensagem com sucesso!\"}");
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body("{\"message\": \"Erro ao enviar suas informações: " + e.getMessage() + "\"}");
        }
    }
}

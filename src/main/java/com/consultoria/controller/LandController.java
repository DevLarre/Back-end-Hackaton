package com.consultoria.controller;

import com.consultoria.model.LandingPage;
import com.consultoria.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RestController
@RequestMapping("/comece-agora-landing-page")
@Validated
public class LandController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarLanding(@RequestBody @Valid LandingPage landingPage) {
        try {
            String logoPathLanding = "uploads/logo.png";
            String emailBody = "<html><body style=\"text-align: center;\">"
                    + "<img src=\"cid:logo\" alt=\"Logo da Empresa\" style=\"display: block; margin: auto;\" /><br><br>"
                    + "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 2px solid rgba(188,188,188); max-width: 600px;\">"
                    + "<h1>Contato Recebido.</h1>"
                    + "<p><strong>Nome:</strong> " + landingPage.getName() + "</p>"
                    + "<p><strong>Telefone:</strong> " + landingPage.getPhone() + "</p>"
                    + "<p><strong>Email:</strong> " + landingPage.getEmail() + "</p>"
                    + "</table>"
                    + "</body></html>";

            emailService.sendSimpleEmail("bakendteste@gmail.com", "\uD83D\uDCF1 Recebemos uma mensagem pelo site: " + landingPage.getName(), emailBody, logoPathLanding);
            return ResponseEntity.ok("{\"message\": \"Recebemos sua mensagem com sucesso!\"}");
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body("{\"message\": \"Erro ao enviar suas informações: " + e.getMessage() + "\"}");
        }
    }
}

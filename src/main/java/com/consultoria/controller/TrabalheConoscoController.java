package com.consultoria.controller;

import com.consultoria.model.TrabalheConosco;
import com.consultoria.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/trabalhe-conosco")
@Validated
public class TrabalheConoscoController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarFormulario(@Valid @ModelAttribute TrabalheConosco trabalheConosco, @RequestParam("curriculo") MultipartFile curriculo) {
        try {
            String logoPathCurriculo = "uploads/logo.png";
            String emailBody = "<html><body style=\"text-align: center;\">"
                    + "<img src=\"cid:logo\" alt=\"Logo da Empresa\" style=\"display: block; margin: auto;\" /><br><br>"
                    + "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 2px solid rgba(226,0,1); max-width: 600px;\">"
                    + "<h1>Currículo recebido.</h1>"
                    + "<p><strong>Nome:</strong> " + trabalheConosco.getNome() + " " + trabalheConosco.getSobrenome() + "</p>"
                    + "<p><strong>Email:</strong> " + trabalheConosco.getEmail() + "</p>"
                    + "<p><strong>Telefone:</strong> " + trabalheConosco.getTelefone() + "</p>"
                    + "<p><strong>Mensagem:</strong> " + trabalheConosco.getMensagem() + "</p>"
                    + "</table>"
                    + "</body></html>";

            emailService.sendEmailWithAttachment("bakendteste@gmail.com", "\uD83D\uDCC4 Recebemos uma candidatura pelo site, " + trabalheConosco.getNome() + " quer se juntar a nossa equipe.", emailBody, logoPathCurriculo, curriculo);
            return ResponseEntity.ok("Sua candidatura foi enviada com sucesso!");
        } catch (MessagingException | IOException e) {
            return ResponseEntity.status(500).body("Erro ao enviar o formulário: " + e.getMessage());
        }
    }
}

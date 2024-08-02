package com.consultoria.controller;

import com.consultoria.exception.ResourceNotFoundException;
import com.consultoria.model.Form;
import com.consultoria.service.EmailService;
import com.consultoria.service.FormService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contato")
public class FormController {

    private static final Logger logger = Logger.getLogger(FormController.class.getName());

    @Autowired
    private FormService formService;

    @Autowired
    private EmailService emailService;

    @Value("${consultoria.formulario.to-email}")
    private String toEmail;

    @GetMapping
    public List<Form> listarTodos() {
        return formService.listarTodos();
    }

    @GetMapping("/{id}")
    public Form findById(@PathVariable UUID id) {
        Optional<Form> form = formService.findById(id);
        if (form.isEmpty()) {
            throw new ResourceNotFoundException("Formulário não encontrado com ID: " + id);
        }
        return form.get();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody Form form, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        Form savedForm = formService.salvar(form);

        try {
            String logoPath = "uploads/logo.png";
            String emailBody = buildEmailBody(savedForm, logoPath);
            emailService.sendSimpleEmail(toEmail, "\uD83D\uDEA8 A Domus Petra recebeu uma nova solicitação de contato.", emailBody, logoPath);

            // Email de confirmação para quem preencheu o formulário
            String emailBodyPessoa = buildConfirmationEmailBody(savedForm, logoPath);
            emailService.sendSimpleEmail(savedForm.getEmail(), "✅ Formulário enviado com sucesso.", emailBodyPessoa, logoPath);

        } catch (MessagingException e) {
            return ResponseEntity.status(500).body("Erro ao enviar o e-mail: " + e.getMessage());
        }

        return ResponseEntity.ok(savedForm);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        formService.deletar(id);
    }

    private String buildEmailBody(Form form, String logoPath) {
        return "<html><body style=\"text-align: center;\">" +
                "<img src=\"cid:logo\" alt=\"Logo da Empresa\" style=\"display: block; margin: auto;\" /><br><br>" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 5px solid rgba(89,173,255); max-width: 600px;\">" +
                "<tr><td align=\"center\" valign=\"top\" style=\"padding: 20px;\">" +
                "<h1>Formulário de contato</h1>" +
                "<p>A empresa <strong>" + form.getEmpresa() + "</strong> preencheu um formulário para contato.</p>" +
                "<p><strong>Empresa:</strong> " + form.getEmpresa() + "</p>" +
                "<p><strong>Nome:</strong> " + form.getNome() + "</p>" +
                "<p><strong>Email:</strong> " + form.getEmail() + "</p>" +
                "<p><strong>Telefone:</strong> " + form.getTelefone() + "</p>" +
                "<p style=\"text-align: justify;\"><strong>Mensagem:</strong> " + form.getMensagem() + "</p>" +
                "</td></tr></table></body></html>";
    }

    private String buildConfirmationEmailBody(Form form, String logoPath) {
        return "<html><body style=\"text-align: center;\">" +
                "<img src=\"cid:logo\" alt=\"Logo da Empresa\" style=\"display: block; margin: auto;\" /><br><br>" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 5px solid rgba(89,173,255); max-width: 600px;\">" +
                "<tr><td align=\"center\" valign=\"top\" style=\"padding: 20px;\">" +
                "<h1>Formulário enviado com sucesso</h1>" +
                "<p>A empresa Domus Petra agradece seu contato, responderemos o mais breve possível.</p>" +
                "<p><strong>Empresa:</strong> " + form.getEmpresa() + "</p>" +
                "<p><strong>Nome:</strong> " + form.getNome() + "</p>" +
                "<p><strong>Email:</strong> " + form.getEmail() + "</p>" +
                "<p><strong>Telefone:</strong> " + form.getTelefone() + "</p>" +
                "<p style=\"text-align: justify;\"><strong>Mensagem:</strong> " + form.getMensagem() + "</p>" +
                "<p>Este e-mail é gerado de forma automática, por favor, não responda.</p>" +
                "<br><br><p>DOMUS PETRA - GESTAO EMPRESARIAL E TRANSFORMACAO DIGITAL LTDA | 11.295.157/0001-08 | 2024 - Todos os Direitos Reservados</p>" +
                "</td></tr></table></body></html>";
    }
}

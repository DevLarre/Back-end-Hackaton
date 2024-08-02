package com.consultoria.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendEmailWithAttachment() throws MessagingException, IOException {
        String to = "test@example.com";
        String subject = "Test Subject";
        String body = "Test Body";
        String logoPath = "logo.png";

        ClassPathResource resource = new ClassPathResource("example.pdf");
        MultipartFile file = new MockMultipartFile("file", resource.getFilename(), "application/pdf", resource.getInputStream());

        MimeMessage mimeMessage = mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        emailService.sendEmailWithAttachment(to, subject, body, logoPath, file);

        ArgumentCaptor<MimeMessage> messageCaptor = ArgumentCaptor.forClass(MimeMessage.class);
        verify(mailSender, times(1)).send(messageCaptor.capture());

        MimeMessage capturedMessage = messageCaptor.getValue();
        MimeMessageHelper helper = new MimeMessageHelper(capturedMessage, true);

        // Verificações
        assertEquals(to, helper.getMimeMessage().getRecipients(MimeMessage.RecipientType.TO)[0].toString());
        assertEquals(subject, helper.getMimeMessage().getSubject());
        assertEquals(body, helper.getMimeMessage().getContent().toString());
    }

    @Test
    public void testSendSimpleEmail() throws MessagingException, IOException {
        String to = "test@example.com";
        String subject = "Test Subject";
        String body = "Test Body";
        String logoPath = "logo.png";

        MimeMessage mimeMessage = mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        // Configura o mock para retornar um destinatário específico
        InternetAddress[] addresses = new InternetAddress[] { new InternetAddress(to) };
        when(mimeMessage.getRecipients(MimeMessage.RecipientType.TO)).thenReturn(addresses);
        when(mimeMessage.getSubject()).thenReturn(subject);
        when(mimeMessage.getContent()).thenReturn(body);

        emailService.sendSimpleEmail(to, subject, body, logoPath);

        ArgumentCaptor<MimeMessage> messageCaptor = ArgumentCaptor.forClass(MimeMessage.class);
        verify(mailSender, times(1)).send(messageCaptor.capture());

        MimeMessage capturedMessage = messageCaptor.getValue();

        // Utilize o MimeMessageHelper para verificar os detalhes
        MimeMessageHelper helper = new MimeMessageHelper(capturedMessage, true);
        assertEquals(to, helper.getMimeMessage().getRecipients(MimeMessage.RecipientType.TO)[0].toString());
        assertEquals(subject, helper.getMimeMessage().getSubject());

        // Verifique se o conteúdo do e-mail é o esperado
        Object content = helper.getMimeMessage().getContent();
        assertEquals(body, content.toString());
    }
}

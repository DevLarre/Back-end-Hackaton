package com.consultoria.model;

import com.consultoria.validation.NoSpecialChars;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "integrity_message")
public class IntegrityMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "A mensagem é obrigatória")
    @Size(min = 10, max = 2000, message = "A mensagem deve ter entre 10 e 2000 caracteres")
    @NoSpecialChars(message = "O campo mensagem contém caracteres especiais inválidos")
    private String mensagem;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

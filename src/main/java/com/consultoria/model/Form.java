package com.consultoria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import com.consultoria.validation.NoSpecialChars;

import java.util.UUID;

@Entity
public class Form {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Empresa é obrigatório")
    @Size(min = 3, message = "Campo empresa deve ter pelo menos 3 caracteres")
    @NoSpecialChars(message = "O campo empresa contém caracteres especiais inválidos")
    private String empresa;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "O campo nome deve ter pelo menos 3 caracteres")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX")
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Adicione um e-mail válido.")
    private String email;

    @NotBlank(message = "Para enviar o formulário, a mensagem é obrigatória")
    @Size(min = 30, max = 999, message = "O campo mensagem deve ter entre 30 e 999 caracteres")
    @NoSpecialChars(message = "O campo mensagem contém caracteres especiais inválidos")
    private String mensagem;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String sobrenome) {
        this.nome = sobrenome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String nome) {
        this.empresa = nome;
    }
}

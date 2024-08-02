package com.consultoria.model;

import com.consultoria.validation.NoSpecialChars;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "landing_page")
public class LandingPage {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter pelo menos 3 caracteres")
    @NoSpecialChars(message = "O campo nome contém caracteres especiais inválidos")
    private String name;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX")
    private String phone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Adicione um e-mail válido.")
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório") @Size(min = 3, message = "Nome deve ter pelo menos 3 caracteres") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Nome é obrigatório") @Size(min = 3, message = "Nome deve ter pelo menos 3 caracteres") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Telefone é obrigatório") @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Telefone é obrigatório") @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Email é obrigatório") @Email(message = "Adicione um e-mail válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Email(message = "Adicione um e-mail válido.") String email) {
        this.email = email;
    }
}

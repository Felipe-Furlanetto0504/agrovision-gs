package br.com.fiap.agrovision.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LoginRequest(

        @NotBlank(message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
        String cpf,

        @NotBlank(message = "Senha é obrigatória")
        String senha
) {}

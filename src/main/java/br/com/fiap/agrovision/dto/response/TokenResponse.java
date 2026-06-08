package br.com.fiap.agrovision.dto.response;

public record TokenResponse(
        String token,
        String tipo,
        String cpf,
        String nome,
        String nomeFazenda
) {}

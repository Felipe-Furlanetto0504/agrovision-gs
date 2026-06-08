package br.com.fiap.agrovision.dto.response;

public record UsuarioResponse(
        Long id,
        String cpf,
        String nome,
        String nomeFazenda
) {}

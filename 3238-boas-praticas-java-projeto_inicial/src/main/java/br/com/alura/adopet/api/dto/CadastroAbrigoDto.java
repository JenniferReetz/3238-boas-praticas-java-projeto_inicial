package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;

public record CadastroAbrigoDto(
    Long id, String nome, String email, String telefone) {
    public CadastroAbrigoDto(AbrigoDto pet){
            this(pet.id(),pet.nome(), pet.email(), pet.telefone());
        }
}

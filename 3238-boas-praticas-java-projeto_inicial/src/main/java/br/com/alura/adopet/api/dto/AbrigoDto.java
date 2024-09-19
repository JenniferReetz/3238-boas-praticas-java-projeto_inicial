package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;

public record AbrigoDto(Long id, String nome, String email, String telefone) {
    public AbrigoDto(Abrigo pet){
        this(pet.getId(),pet.getNome(), pet.getEmail(), pet.getTelefone());
    }
}

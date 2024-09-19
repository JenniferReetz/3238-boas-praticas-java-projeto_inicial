package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Tutor;

import java.util.List;

public record TutorDto(Long id, String nome, String telefone, String email, List<Adocao> adocoes) {
    public TutorDto(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getTelefone(), tutor.getEmail(), tutor.getAdocoes());
    }


}

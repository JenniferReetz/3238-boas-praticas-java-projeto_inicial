package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;

public record CadastroPetDto(TipoPet tipo, String nome, String raca, Integer idade, String cor, Float peso,
                             Abrigo abrigo , Boolean adotado) {
    public CadastroPetDto(PetDTO pet) {
        this(pet.tipo(),pet.nome() ,pet.raca(),pet.idade() ,pet.cor(),pet.peso(),pet.abrigo() ,pet.adotado());
    }
}
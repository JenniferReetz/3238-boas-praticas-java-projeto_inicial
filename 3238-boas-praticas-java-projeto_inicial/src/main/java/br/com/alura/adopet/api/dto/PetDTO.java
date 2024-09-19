package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;

public record PetDTO(TipoPet tipo, String nome, String raca, Integer idade, String cor, Float peso,Abrigo abrigo ,Boolean adotado
                     )
{
    public PetDTO(Pet pet){
        this(pet.getTipo(),pet.getNome() ,pet.getRaca(),pet.getIdade() ,pet.getCor(),pet.getPeso(),pet.getAbrigo() ,pet.getAdotado());
    }


}

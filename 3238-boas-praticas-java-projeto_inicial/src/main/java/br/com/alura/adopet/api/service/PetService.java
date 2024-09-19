package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.dto.PetDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PetService {

    @Autowired
    private PetRepository repository;
    public List<PetDTO> buscarPetsDisponiveis() {
        return repository.findAllByAdotadoFalse()
                .stream()
                .map(PetDTO::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {

    }
}

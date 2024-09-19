package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoDto;
import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.PetDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class AbrigoService {


    @Autowired
    private AbrigoRepository abrigoRepository;
    @Autowired
    private PetRepository PetRepository;
    @Autowired
    private Abrigo abrigo;
    public List<AbrigoDto> listar() {
        return abrigoRepository
                .findAll()
                .stream()
                .map(AbrigoDto::new)
                .toList();
    }

    public void cadastrar(CadastroAbrigoDto dto) {

        boolean jaCadastrado = abrigoRepository.existsByNomeOrTelefoneOrEmail();

        if (jaCadastrado) {
            ResponseEntity.badRequest().body("Dados já cadastrados para outro abrigo!");
        } else {
            abrigoRepository.save(abrigo);
        }
    }

    public List<PetDTO> listarPetsDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);
        return PetRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(PetDTO::new)
                .toList();

    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = abrigoRepository.findByNome(id);
        }catch (NumberFormatException exception){
        optional = abrigoRepository.findByNome(Long.valueOf(idOuNome));
        }
        return optional.orElseThrow(() -> new ValidacaoException("Abrigo Não encontrado"));
    }

}

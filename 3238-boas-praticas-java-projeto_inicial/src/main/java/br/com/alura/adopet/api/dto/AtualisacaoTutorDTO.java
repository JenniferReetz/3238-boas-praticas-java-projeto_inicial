package br.com.alura.adopet.api.dto;



public record AtualisacaoTutorDTO(Long id,String nome, String telefone, String email) {
    public AtualisacaoTutorDTO(TutorDto tutor){this(tutor.id(),tutor.nome(), tutor.telefone(), tutor.email());}

}

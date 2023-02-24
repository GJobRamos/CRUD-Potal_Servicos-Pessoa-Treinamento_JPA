package br.com.ntt.jpa.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaDto {

    @NotEmpty(message = "O nome não pode vir nulo ou em branco!")
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private EnderecoDto endereco;
}

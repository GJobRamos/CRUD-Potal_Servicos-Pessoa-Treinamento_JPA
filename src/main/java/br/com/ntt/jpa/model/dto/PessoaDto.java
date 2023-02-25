package br.com.ntt.jpa.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
public class PessoaDto {

    @NotBlank(message = "O nome não pode vir nulo ou em branco!")
    private String nome;
    @NotBlank(message = "O sobrenome não pode vir nulo ou em branco!")
    private String sobrenome;
    @CPF(message = "CPF precisa ser válido ou não cadastrado!")
    private String cpf;
    @Email(message = "e-mail precisa ser válido ou não cadastrado!")
    private String email;
    private EnderecoDto endereco;
}

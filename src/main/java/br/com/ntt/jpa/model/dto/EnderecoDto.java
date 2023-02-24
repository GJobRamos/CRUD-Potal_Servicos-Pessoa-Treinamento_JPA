package br.com.ntt.jpa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
    private String logradouro;
    private String numero;

    private String complemento;
    private String cep;

    private String estado;

    private String cidade;
}

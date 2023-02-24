package br.com.ntt.jpa.service.populator;

import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.model.dto.EnderecoDto;
import br.com.ntt.jpa.model.dto.PessoaDto;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source,TARGET target);

}

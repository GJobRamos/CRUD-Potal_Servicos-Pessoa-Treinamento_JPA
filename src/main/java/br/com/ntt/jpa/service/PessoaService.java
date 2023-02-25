package br.com.ntt.jpa.service;

import br.com.ntt.jpa.model.dto.PessoaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PessoaService {
    List<PessoaDto> getListaPessoas();
    PessoaDto getPessoaPorId(Long id);
    void cadastrarPessoa(PessoaDto pessoa);
    PessoaDto deletarCadastro(Long id);
}

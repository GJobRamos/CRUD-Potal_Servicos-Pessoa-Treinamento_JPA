package br.com.ntt.jpa.service.impl;

import br.com.ntt.jpa.exception.PessoaNaoEncontradaException;
import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.model.dto.PessoaDto;
import br.com.ntt.jpa.repository.EnderecoRepository;
import br.com.ntt.jpa.repository.PessoaRepository;
import br.com.ntt.jpa.service.PessoaService;
import br.com.ntt.jpa.service.populator.Populator;
import br.com.ntt.jpa.service.populator.impl.PessoaPopulatorImpl;
import br.com.ntt.jpa.service.populator.impl.ReversePopulatorImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor // a depencencia projectlombok pdefine um construtor com os todos os argumentos da classe
@Service
public class PessoaServiceImpl implements PessoaService {
    private EnderecoRepository enderecoRepository;
    private PessoaRepository pessoaRepository;
    private Populator<PessoaDto,Pessoa> pessoaPopulator;
    private Populator<Pessoa, PessoaDto> pessoaReversePopulator;

    @Override
    public List<PessoaDto> getListaPessoas() {
        List<PessoaDto> pessoaDtoList = new ArrayList<>();
        List<Pessoa> pessoaList = getPessoaRepository().findAll();

        for(Pessoa p: pessoaList) {
            PessoaDto pessoaDto = new PessoaDto();

            pessoaReversePopulator.populate(p, pessoaDto);

            pessoaDtoList.add(pessoaDto);
        }

        return pessoaDtoList;
    }

    @Override
    public PessoaDto getPessoaPorId(Long id) {
        PessoaDto pessoaDto = new PessoaDto();
        Pessoa pessoa = getPessoaRepository().findById(id).orElseThrow(() -> new PessoaNaoEncontradaException("Não existe nenhum cadastro com esse ID!"));

        pessoaReversePopulator.populate(pessoa, pessoaDto);

        return  pessoaDto;
    }

    @Override
    public void cadastrarPessoa(PessoaDto pessoaDto) {
        Pessoa pessoa = new Pessoa();
        pessoaPopulator.populate(pessoaDto, pessoa);
        getPessoaRepository().save(pessoa);
    }

    @Override
    public PessoaDto deletarCadastro(Long id) {
        PessoaDto pessoaDto;

        if(getPessoaRepository().existsById(id)) {
            pessoaDto = new PessoaDto();
            Optional<Pessoa> pessoa = getPessoaRepository().findById(id);

            getPessoaRepository().deleteById(id);
            getEnderecoRepository().deleteById(id);

            pessoaReversePopulator.populate(pessoa.get(), pessoaDto);
        } else {
            throw new PessoaNaoEncontradaException("Não existe nenhum cadastro com esse ID!");
        }

        return pessoaDto;
    }

    public PessoaRepository getPessoaRepository() {
        return pessoaRepository;
    }

    public EnderecoRepository getEnderecoRepository() {
        return enderecoRepository;
    }
}

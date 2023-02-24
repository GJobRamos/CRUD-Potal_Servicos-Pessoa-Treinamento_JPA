package br.com.ntt.jpa.service.populator.impl;

import br.com.ntt.jpa.model.Cidade;
import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Estado;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.model.dto.EnderecoDto;
import br.com.ntt.jpa.model.dto.PessoaDto;
import br.com.ntt.jpa.repository.CidadeRepository;
import br.com.ntt.jpa.repository.EnderecoRepository;
import br.com.ntt.jpa.repository.EstadoRepository;
import br.com.ntt.jpa.service.populator.Populator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class PessoaPopulatorImpl implements Populator<PessoaDto,Pessoa> {
    private EstadoRepository estadoRepository;
    private CidadeRepository cidadeRepository;
    private EnderecoRepository enderecoRepository;

    @Override
    public void populate(PessoaDto source, Pessoa target) {
        target.setNome(source.getNome());
        target.setSobrenome(source.getSobrenome());
        target.setCpf(source.getCpf());
        target.setEmail(source.getEmail());

        populateEndereco(source.getEndereco(), target);
    }

    private void populateEndereco(EnderecoDto source, Pessoa target) {
        Endereco endereco = new Endereco();
        target.setEndereco(endereco);

        target.getEndereco().setLogradouro(source.getLogradouro());
        target.getEndereco().setNumero(source.getNumero());
        target.getEndereco().setComplemento(source.getComplemento());
        target.getEndereco().setCep(source.getCep());

        pupulateCidade(source.getCidade(), target);
        populateEstado(source.getEstado(), target);

        enderecoRepository.save(target.getEndereco());
    }

    private  void pupulateCidade(String source, Pessoa target) {
        if (!cidadeRepository.existsCidadeByNome(source)) {
            Cidade cidade = Cidade.criarNovaCidade(source);
            target.getEndereco().setCidade(cidade);

            cidadeRepository.save(cidade);

        } else {
            Cidade cidade = cidadeRepository.getCidadeByNome(source);
            target.getEndereco().setCidade(cidade);
        }
    }

    private void populateEstado(String source, Pessoa target) {
        Estado estado;

        if (!estadoRepository.existsEstadoByNome(source)) {
            estado = Estado.ciarNovoEstado(source);
            estado.getListaCidades().add(target.getEndereco().getCidade());
            target.getEndereco().setEstado(estado);
        } else {
            estado = estadoRepository.getEstadoByNome(source);

            if (!estado.getListaCidades().contains(target.getEndereco().getCidade())) {
                estado.getListaCidades().add(target.getEndereco().getCidade());
            }

            target.getEndereco().setEstado(estado);
        }

        estadoRepository.save(estado);
    }
}

package br.com.ntt.jpa.controller;

import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.model.dto.PessoaDto;
import br.com.ntt.jpa.service.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor // a depencencia projectlombok pdefine um construtor com os todos os argumentos da classe
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    @GetMapping("/getListaPessoas")
    public List<PessoaDto> getListaPessoas() {
        return getPessoaService().getListaPessoas();
    }

    @GetMapping("/getPessoaPorId/{id}")
    public PessoaDto getPessoaPorId(@PathVariable String id) {
        return getPessoaService().getPessoaPorId(Long.parseLong(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaDto> cadastrarPessoa(@Valid @RequestBody PessoaDto pessoa) {
        getPessoaService().cadastrarPessoa(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @DeleteMapping("/deletarCadastro/{id}")
    public ResponseEntity<PessoaDto> deletarCadastro(@PathVariable String id) {
        PessoaDto pessoaDeletada = getPessoaService().deletarCadastro(Long.parseLong(id));
        return new ResponseEntity<>(pessoaDeletada, HttpStatus.OK);
    }

    public PessoaService getPessoaService() {
        return pessoaService;
    }
}

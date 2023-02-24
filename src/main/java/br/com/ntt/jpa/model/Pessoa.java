package br.com.ntt.jpa.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de getters para que o código fique enxuto
@Setter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de setters para que o código fique enxuto
@NoArgsConstructor // a depencencia projectlombok pdefine um construtor default
@Entity(name = "tb_pessoas") // determina que esta classe será uma tabela
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    @OneToOne
    private Endereco endereco;

    public static Pessoa criarNovaPessoa(String nome, String sobrenome, String cpf, String email, Endereco endereco) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(nome);
        pessoa.setSobrenome(sobrenome);
        pessoa.setCpf(cpf);
        pessoa.setEmail(email);
        pessoa.setEndereco(endereco);

        return pessoa;
    }
}

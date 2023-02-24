package br.com.ntt.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de getters para que o código fique enxuto
@Setter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de setters para que o código fique enxuto
@NoArgsConstructor // a depencencia projectlombok pdefine um construtor default
@Entity(name = "tb_cidades") // determina que esta classe será uma tabela
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public static Cidade criarNovaCidade(String nome) {
        Cidade cidade = new Cidade();

        cidade.setNome(nome);

        return cidade;
    }
}
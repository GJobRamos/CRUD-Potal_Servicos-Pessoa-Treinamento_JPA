package br.com.ntt.jpa.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de getters para que o código fique enxuto
@Setter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de setters para que o código fique enxuto
@NoArgsConstructor // a depencencia projectlombok pdefine um construtor default
@Entity(name = "tb_estados") // determina que esta classe será uma tabela
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    private List<Cidade> listaCidades;

    public static Estado ciarNovoEstado(String nome) {
        Estado estado = new Estado();
        List<Cidade> cidades = new ArrayList<>();

        estado.setNome(nome);
        estado.setListaCidades(cidades);

        return estado;
    }
}

package br.com.ntt.jpa.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de getters para que o código fique enxuto
@Setter // a dependência projectlombok permite a anotaçao para o controle das criaçoes de setters para que o código fique enxuto
@NoArgsConstructor // a depencencia projectlombok pdefine um construtor default
@Entity(name = "tb_enderecos") // determina que esta classe será uma tabela
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;

    private String complemento;
    private String cep;
    @OneToOne
    private Estado estado;
    @OneToOne
    private Cidade cidade;

    public static Endereco criarNovoEndereco(String logradouro, String numero, String complemento, String cep, Estado estado, Cidade cidade) {
        Endereco endereco = new Endereco();

        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setCep(cep);
        endereco.setEstado(estado);
        endereco.setCidade(cidade);

        return endereco;
    }

}

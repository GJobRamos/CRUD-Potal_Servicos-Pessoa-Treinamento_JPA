package br.com.ntt.jpa.repository;

import br.com.ntt.jpa.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    boolean existsCidadeByNome(String nome);

    Cidade getCidadeByNome(String nome);
}

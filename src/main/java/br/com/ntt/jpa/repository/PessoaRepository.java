package br.com.ntt.jpa.repository;

import br.com.ntt.jpa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

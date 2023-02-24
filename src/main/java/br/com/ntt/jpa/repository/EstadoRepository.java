package br.com.ntt.jpa.repository;

import br.com.ntt.jpa.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    boolean existsEstadoByNome(String nome);

    Estado getEstadoByNome(String nome);
}

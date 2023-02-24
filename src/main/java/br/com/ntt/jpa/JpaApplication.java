package br.com.ntt.jpa;

import br.com.ntt.jpa.model.Cidade;
import br.com.ntt.jpa.model.Estado;
import br.com.ntt.jpa.repository.CidadeRepository;
import br.com.ntt.jpa.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Cidade campinas = Cidade.criarNovaCidade("Campinas");
//		cidadeRepository.save(campinas);
//		Cidade saoPaulo = Cidade.criarNovaCidade("São Paulo");
//		cidadeRepository.save(saoPaulo);
//		Cidade portoAlegre = Cidade.criarNovaCidade("Porto Alegre");
//		cidadeRepository.save(portoAlegre);
//		Cidade macapa = Cidade.criarNovaCidade("Macapá");
//		cidadeRepository.save(macapa);
//		Cidade brasilia = Cidade.criarNovaCidade("Brasilía");
//		cidadeRepository.save(brasilia);
//
//		Estado sp = Estado.ciarNovoEstado("São Paulo");
//		sp.getListaCidades().add(campinas);
//		sp.getListaCidades().add(saoPaulo);
//		estadoRepository.save(sp);
//
//		Estado rs = Estado.ciarNovoEstado("Rio Grande do Sul");
//		rs.getListaCidades().add(portoAlegre);
//		estadoRepository.save(rs);
//
//		Estado am = Estado.ciarNovoEstado("Amapá");
//		am.getListaCidades().add(macapa);
//		estadoRepository.save(am);
//
//		Estado df = Estado.ciarNovoEstado("Distrito Federal");
//		df.getListaCidades().add(brasilia);
//		estadoRepository.save(df);

	}

}

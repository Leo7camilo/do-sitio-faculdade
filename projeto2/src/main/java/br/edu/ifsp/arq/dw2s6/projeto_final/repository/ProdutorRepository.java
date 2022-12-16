package br.edu.ifsp.arq.dw2s6.projeto_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Produtor;

public interface ProdutorRepository extends JpaRepository<Produtor, Long>, JpaSpecificationExecutor<Produtor>{

	Optional<Produtor> findByNome(String nome);

}

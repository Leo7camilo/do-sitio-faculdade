package br.edu.ifsp.arq.dw2s6.projeto_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Mercadoria;

@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, Long>, JpaSpecificationExecutor<Mercadoria>{

	Optional<Mercadoria> findByDescricao(String descricao);

}

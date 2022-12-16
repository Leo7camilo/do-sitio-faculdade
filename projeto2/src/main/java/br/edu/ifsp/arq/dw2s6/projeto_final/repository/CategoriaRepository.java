package br.edu.ifsp.arq.dw2s6.projeto_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria>{

	Optional<Categoria> findByNome(String nome);

}

package br.edu.ifsp.arq.dw2s6.projeto_final.specification;

import org.springframework.data.jpa.domain.Specification;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Categoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Mercadoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Produtor;
import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

public class SpecificationTemplate {
	
	@And({
		@Spec(path = "nome", spec = Equal.class),
		@Spec(path = "email", spec = Like.class),
	})
	public interface UserSpec extends Specification<Usuario>{};
	
	@And({
		@Spec(path = "nome", spec = Like.class)
	})
	public interface CategoriaSpec extends Specification<Categoria>{};
	
	@And({
		@Spec(path = "nome", spec = Like.class)
	})
	public interface ProdutorSpec extends Specification<Produtor>{};
	
	@And({
		@Spec(path = "descricao", spec = Like.class)
	})
	public interface MercadoriaSpec extends Specification<Mercadoria>{};
}
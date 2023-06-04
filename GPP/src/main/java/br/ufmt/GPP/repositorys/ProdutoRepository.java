package br.ufmt.GPP.repositorys;

import br.ufmt.GPP.models.Produto;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ProdutoRepository  extends JpaRepositoryImplementation<Produto,Integer> {
}

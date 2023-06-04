package br.ufmt.GPP.repositorys;

import br.ufmt.GPP.models.Item;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ItemRepository extends JpaRepositoryImplementation<Item, Integer> {
}

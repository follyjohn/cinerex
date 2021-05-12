package org.hermit.cinerex.film.repository;

import org.hermit.cinerex.film.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    
}

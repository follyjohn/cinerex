package org.hermit.cinerex.film.repository;

import org.hermit.cinerex.film.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    
}

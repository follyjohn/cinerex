package org.hermit.cinerex.film.repository;

import org.hermit.cinerex.film.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long>{
    
}

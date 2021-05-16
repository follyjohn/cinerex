package org.hermit.cinerex.repository;

import org.hermit.cinerex.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long>{
    
}

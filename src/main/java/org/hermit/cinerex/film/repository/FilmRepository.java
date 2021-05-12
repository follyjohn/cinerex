package org.hermit.cinerex.film.repository;

import org.hermit.cinerex.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
    
}

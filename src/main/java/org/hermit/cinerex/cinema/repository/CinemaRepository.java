package org.hermit.cinerex.cinema.repository;

import org.hermit.cinerex.cinema.model.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long> {
    
}

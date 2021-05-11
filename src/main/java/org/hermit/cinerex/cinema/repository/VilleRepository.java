package org.hermit.cinerex.cinema.repository;

import org.hermit.cinerex.cinema.model.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends CrudRepository<Ville, Long> {
    
}

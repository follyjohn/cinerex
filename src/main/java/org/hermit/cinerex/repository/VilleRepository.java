package org.hermit.cinerex.repository;

import org.hermit.cinerex.model.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends CrudRepository<Ville, Long> {
    
}

package org.hermit.cinerex.salle.repository;

import org.hermit.cinerex.salle.model.Salle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Long> {
    
}

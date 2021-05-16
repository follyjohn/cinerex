package org.hermit.cinerex.repository;

import org.hermit.cinerex.model.Salle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Long> {
    
}

package org.hermit.cinerex.projection.repository;

import org.hermit.cinerex.projection.model.Seance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends CrudRepository<Seance, Long> {
    
}

package org.hermit.cinerex.repository;

import org.hermit.cinerex.model.Seance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends CrudRepository<Seance, Long> {
    
}

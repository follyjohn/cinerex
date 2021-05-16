package org.hermit.cinerex.repository;

import org.hermit.cinerex.model.Projection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectionRepository extends CrudRepository<Projection, Long> {
    
}

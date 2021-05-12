package org.hermit.cinerex.projection.repository;

import org.hermit.cinerex.projection.model.Projection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectionRepository extends CrudRepository<Projection, Long> {
    
}

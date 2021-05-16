package org.hermit.cinerex.repository;

import org.hermit.cinerex.model.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long>{

}

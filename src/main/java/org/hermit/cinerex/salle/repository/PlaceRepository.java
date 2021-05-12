package org.hermit.cinerex.salle.repository;

import org.hermit.cinerex.salle.model.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long>{

}

package org.hermit.cinerex.salle.repository;

import org.hermit.cinerex.salle.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{

}

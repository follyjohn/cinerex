package org.hermit.cinerex.cinema.repository;

import org.hermit.cinerex.cinema.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
    
}

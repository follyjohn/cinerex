package org.hermit.cinerex.salle.repository;

import org.hermit.cinerex.salle.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Long> {
    
}

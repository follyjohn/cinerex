package org.hermit.cinerex.tikets.repository;

import org.hermit.cinerex.tikets.model.Tiket;
import org.springframework.data.repository.CrudRepository;

public interface TiketRepository extends CrudRepository<Tiket, Long> {
    
}

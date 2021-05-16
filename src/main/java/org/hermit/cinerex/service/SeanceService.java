package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Seance;
import org.hermit.cinerex.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SeanceService {
    
    @Autowired
    private SeanceRepository seanceRepository;

    public Optional<Seance> getSeance(final Long id) {
        return seanceRepository.findById(id);
    }

    public Iterable<Seance> getAllSeance() {
        return seanceRepository.findAll();
    }

    public void deleteSeance(final Long id) {
        seanceRepository.deleteById(id);
    }

    public Seance saveSeance(Seance seance) {
        return seanceRepository.save(seance);
    }
}

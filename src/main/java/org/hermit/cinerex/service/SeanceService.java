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

    
    /** 
     * @param id
     * @return Optional<Seance>
     */
    public Optional<Seance> getSeance(final Long id) {
        return seanceRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Seance>
     */
    public Iterable<Seance> getAllSeance() {
        return seanceRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteSeance(final Long id) {
        seanceRepository.deleteById(id);
    }

    
    /** 
     * @param seance
     * @return Seance
     */
    public Seance saveSeance(Seance seance) {
        return seanceRepository.save(seance);
    }
}

package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Salle;
import org.hermit.cinerex.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    
    /** 
     * @param id
     * @return Optional<Salle>
     */
    public Optional<Salle> getSalle(final Long id) {
        return salleRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Salle>
     */
    public Iterable<Salle> getAllSalle() {
        return salleRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteSalle(final Long id) {
        salleRepository.deleteById(id);
    }

    
    /** 
     * @param salle
     * @return Salle
     */
    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }
}

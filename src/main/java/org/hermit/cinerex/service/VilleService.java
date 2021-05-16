package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Ville;
import org.hermit.cinerex.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleService {
    
    @Autowired
    private VilleRepository villeRepository;

    
    /** 
     * @param id
     * @return Optional<Ville>
     */
    public Optional<Ville> getVille(final long id) {
        return villeRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Ville>
     */
    public Iterable<Ville> getAllVille() {
        return villeRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteVille(final long id) {
        villeRepository.deleteById(id);
    }

    
    /** 
     * @param ville
     * @return Ville
     */
    public Ville saveVille(Ville ville) {
        return  villeRepository.save(ville);
    }
}

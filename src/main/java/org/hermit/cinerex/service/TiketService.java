package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Tiket;
import org.hermit.cinerex.repository.TiketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiketService {
    
    @Autowired
    private TiketRepository tiketRepository;

    
    /** 
     * @param id
     * @return Optional<Tiket>
     */
    public Optional<Tiket> getTiket(final Long id) {
        return tiketRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Tiket>
     */
    public Iterable<Tiket> getAllTiket() {
        return tiketRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteTiket(final Long id) {
        tiketRepository.deleteById(id);
    }

    
    /** 
     * @param tiket
     * @return Tiket
     */
    public Tiket saveTiket(Tiket tiket) {
        return tiketRepository.save(tiket);
    }
}

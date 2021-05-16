package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Cinema;
import org.hermit.cinerex.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    
    @Autowired
    private CinemaRepository cinemaRepository;

    
    /** 
     * @param id
     * @return Optional<Cinema>
     */
    public Optional<Cinema> getCinema(final Long id) {
        return cinemaRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Cinema>
     */
    public Iterable<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteCinema(final Long id) {
        cinemaRepository.deleteById(id);
    }

    
    /** 
     * @param cinema
     * @return Cinema
     */
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}

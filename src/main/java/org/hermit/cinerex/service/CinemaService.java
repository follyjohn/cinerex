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

    public Optional<Cinema> getCinema(final Long id) {
        return cinemaRepository.findById(id);
    }

    public Iterable<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    public void deleteCinema(final Long id) {
        cinemaRepository.deleteById(id);
    }

    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}

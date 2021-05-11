package org.hermit.cinerex.cinema.service;

import java.util.Optional;

import org.hermit.cinerex.cinema.model.Cinema;
import org.hermit.cinerex.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    
    @Autowired
    private CinemaRepository cinemaRepository;

    public Optional<Cinema> getCinema(final long id) {
        return cinemaRepository.findById(id);
    }

    public Iterable<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    public void deleteCinema(final long id) {
        cinemaRepository.deleteById(id);
    }

    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}

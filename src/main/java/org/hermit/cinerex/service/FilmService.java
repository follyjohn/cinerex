package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Film;
import org.hermit.cinerex.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    
    @Autowired
    private FilmRepository filmRepository;

    public Optional<Film> getFilm(final Long id) {
        return filmRepository.findById(id);
    }

    public Iterable<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    public void deleteFilm(final Long id) {
        filmRepository.deleteById(id);
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }
}

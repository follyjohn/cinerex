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

    
    /** 
     * @param id
     * @return Optional<Film>
     */
    public Optional<Film> getFilm(final Long id) {
        return filmRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Film>
     */
    public Iterable<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteFilm(final Long id) {
        filmRepository.deleteById(id);
    }

    
    /** 
     * @param film
     * @return Film
     */
    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }
}

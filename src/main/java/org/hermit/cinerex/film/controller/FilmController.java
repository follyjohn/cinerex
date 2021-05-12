package org.hermit.cinerex.film.controller;

import java.util.Optional;

import org.hermit.cinerex.film.model.Film;
import org.hermit.cinerex.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
    
    @Autowired
    private FilmService filmService;

    @GetMapping("/films")
    public Iterable<Film> getAllFilm() {
        return filmService.getAllFilm();
    }

    @PostMapping("/films")
    public String createFilm(@RequestBody Film film) {
        filmService.saveFilm(film);
        return "Film enregistre";
    }

    @GetMapping(value = "films/{id}")
    public Film getFilm(@PathVariable Long id) {
        Optional<Film> film = filmService.getFilm(id);
        if (film.isPresent()) {
            return film.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "films/{id}")
    public String deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return "Film supprime";
    }

    @PutMapping(value = "films/{id}")
    public Film putFilm(@PathVariable Long id, @RequestBody Film newFilm) {
        return filmService.getFilm(id).map(film -> {
            film.setTitre(newFilm.getTitre());
            film.setCategorie(newFilm.getCategorie());
            film.setDateSortie(newFilm.getDateSortie());
            film.setDescription(newFilm.getDescription());
            film.setDuree(newFilm.getDuree());
            film.setPhoto(newFilm.getPhoto());
            film.setRealisateur(newFilm.getRealisateur());
            return filmService.saveFilm(film);
        }).orElseGet(() -> {
            newFilm.setId(id);
            return filmService.saveFilm(newFilm);
        });
    }
}

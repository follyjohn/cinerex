package org.hermit.cinerex.cinema.controller;

import org.hermit.cinerex.cinema.model.Cinema;
import org.hermit.cinerex.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemas")
    public Iterable<Cinema> getAllCinema() {
        return cinemaService.getAllCinema();
    }

    @PostMapping("/cinemas")
    public String createCinema(Cinema cinema) {
        cinemaService.saveCinema(cinema);
        return "Cinema enregistre";
    }
}

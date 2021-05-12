package org.hermit.cinerex.cinema.controller;

import java.util.Optional;

import org.hermit.cinerex.cinema.model.Cinema;
import org.hermit.cinerex.cinema.model.Ville;
import org.hermit.cinerex.cinema.service.CinemaService;
import org.hermit.cinerex.cinema.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CinemaController {
    
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemas")
    public Iterable<Cinema> getAllCinema() {
        return cinemaService.getAllCinema();
    }

    @PostMapping("/cinemas")
    public String createCinema(@RequestBody Cinema cinema) {
        cinemaService.saveCinema(cinema);
        return "Cinema enregistre";
    }

    @GetMapping(value="cinemas/{id}")
    public Cinema getCinema(@PathVariable Long id) {
        Optional<Cinema> cinema = cinemaService.getCinema(id);
        if(cinema.isPresent()){
            return cinema.get();
        }else{
            return null;
        }
    }

    @DeleteMapping(value="cinemas/{id}")
    public String deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
        return "Cinema supprime";
    }

    @PutMapping(value="cinemas/{id}")
    public Cinema putCinema(@PathVariable Long id, @RequestBody Cinema newCinema) {
        return cinemaService.getCinema(id).map(cinema -> {
            cinema.setName(newCinema.getName());
            cinema.setNombreSalles(newCinema.getNombreSalles());
            cinema.setVille(newCinema.getVille());
            cinema.setLatitude(newCinema.getLatitude());
            cinema.setLongitude(newCinema.getLongitude());
            cinema.setAltitude(newCinema.getAltitude());
            return cinemaService.saveCinema(cinema);
        }).orElseGet(() -> {
            newCinema.setId(id);
            return cinemaService.saveCinema(newCinema);
        });
    }

    
    
}

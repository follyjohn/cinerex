package org.hermit.cinerex.controller;

import java.util.Optional;

import org.hermit.cinerex.model.Salle;
import org.hermit.cinerex.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalleController {
    
    @Autowired
    private SalleService salleService;

    @GetMapping("/salles")
    public Iterable<Salle> getAllSalle() {
        return salleService.getAllSalle();
    }

    @PostMapping("/salles")
    public String createSalle(@RequestBody Salle salle) {
        salleService.saveSalle(salle);
        return "Salle enregistre";
    }

    @GetMapping(value = "salles/{id}")
    public Salle getSalle(@PathVariable Long id) {
        Optional<Salle> salle = salleService.getSalle(id);
        if (salle.isPresent()) {
            return salle.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "salles/{id}")
    public String deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return "Salle supprime";
    }

    @PutMapping(value = "salles/{id}")
    public Salle putSalle(@PathVariable Long id, @RequestBody Salle newSalle) {
        return salleService.getSalle(id).map(salle -> {
            salle.setName(newSalle.getName());
            return salleService.saveSalle(salle);
        }).orElseGet(() -> {
            newSalle.setId(id);
            return salleService.saveSalle(newSalle);
        });
    }
}

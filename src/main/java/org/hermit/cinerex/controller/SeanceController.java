package org.hermit.cinerex.controller;

import java.util.Optional;

import org.hermit.cinerex.model.Seance;
import org.hermit.cinerex.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SeanceController {
    
    @Autowired
    public SeanceService seanceService;

    @GetMapping("/seances")
    public Iterable<Seance> getAllSeance() {
        return seanceService.getAllSeance();
    }

    @PostMapping("/seances")
    public String createSeance(@RequestBody Seance seance) {
        seanceService.saveSeance(seance);
        return "Seance enregistre";
    }

    @GetMapping(value = "seances/{id}")
    public Seance getSeance(@PathVariable Long id) {
        Optional<Seance> seance = seanceService.getSeance(id);
        if (seance.isPresent()) {
            return seance.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "seances/{id}")
    public String deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return "Seance supprime";
    }

    @PutMapping(value = "seances/{id}")
    public Seance putSeance(@PathVariable Long id, @RequestBody Seance newSeance) {
        return seanceService.getSeance(id).map(seance -> {
            seance.setDateDebut(newSeance.getDateDebut());
            return seanceService.saveSeance(seance);
        }).orElseGet(() -> {
            newSeance.setId(id);
            return seanceService.saveSeance(newSeance);
        });
    }
}

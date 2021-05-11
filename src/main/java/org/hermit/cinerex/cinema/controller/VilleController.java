package org.hermit.cinerex.cinema.controller;

import org.hermit.cinerex.cinema.model.Ville;
import org.hermit.cinerex.cinema.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VilleController {
    
    @Autowired
    private VilleService villeService;

    @GetMapping("/villes")
    public Iterable<Ville> getAllVille(){
        return villeService.getAllVille();
    }

    @PostMapping("/villes")
    public String createVille(Ville ville){
        villeService.saveVille(ville);
        return "Ville enregistre";
    }
}

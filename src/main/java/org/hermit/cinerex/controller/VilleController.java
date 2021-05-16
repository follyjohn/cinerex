package org.hermit.cinerex.controller;

import java.util.Optional;

import org.hermit.cinerex.model.Ville;
import org.hermit.cinerex.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String createVille(@RequestBody Ville ville){
        villeService.saveVille(ville);
        return "Ville enregistre";
    }

    @GetMapping(value = "villes/{id}")
    public Ville getVille(@PathVariable Long id) {
        Optional<Ville> ville = villeService.getVille(id);
        if (ville.isPresent()) {
            return ville.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "villes/{id}")
    public String deleteVille(@PathVariable Long id) {
        villeService.deleteVille(id);
        return "Ville supprime";
    }

    @PutMapping(value = "villes/{id}")
    public Ville putVille(@PathVariable Long id, @RequestBody Ville newVille) {
        return villeService.getVille(id).map(ville -> {
            ville.setName(newVille.getName());
            ville.setLatitude(newVille.getLatitude());
            ville.setLongitude(newVille.getLongitude());
            ville.setAltitude(newVille.getAltitude());
            return villeService.saveVille(ville);
        }).orElseGet(() -> {
            newVille.setId(id);
            return villeService.saveVille(newVille);
        });
    }
}

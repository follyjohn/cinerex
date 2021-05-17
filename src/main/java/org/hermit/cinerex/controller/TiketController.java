package org.hermit.cinerex.controller;

import java.util.Optional;

import org.hermit.cinerex.model.Tiket;
import org.hermit.cinerex.service.TiketService;
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
@RequestMapping("/api/tikets")
public class TiketController {
    
    @Autowired
    private TiketService tiketService;

    
    /** 
     * @return Iterable<Tiket>
     */
    @GetMapping("/")
    public Iterable<Tiket> getAllTiket() {
        return tiketService.getAllTiket();
    }

    
    /** 
     * @param tiket
     * @return String
     */
    @PostMapping("/")
    public String createTiket(@RequestBody Tiket tiket) {
        tiketService.saveTiket(tiket);
        return "Tiket enregistre";
    }

    
    /** 
     * @param id
     * @return Tiket
     */
    @GetMapping(value = "/{id}")
    public Tiket getTiket(@PathVariable Long id) {
        Optional<Tiket> tiket = tiketService.getTiket(id);
        if (tiket.isPresent()) {
            return tiket.get();
        } else {
            return null;
        }
    }

    
    /** 
     * @param id
     * @return String
     */
    @DeleteMapping(value = "/{id}")
    public String deleteTiket(@PathVariable Long id) {
        tiketService.deleteTiket(id);
        return "Tiket supprime";
    }

    
    /** 
     * @param id
     * @param newTiket
     * @return Tiket
     */
    @PutMapping(value = "/{id}")
    public Tiket putTiket(@PathVariable Long id, @RequestBody Tiket newTiket) {
        return tiketService.getTiket(id).map(tiket -> {
            tiket.setCodePayement(newTiket.getCodePayement());
            tiket.setNomClient(newTiket.getNomClient());
            tiket.setPrix(newTiket.getPrix());
            tiket.setPlace(newTiket.getPlace());
            tiket.setProjection(newTiket.getProjection());
            return tiketService.saveTiket(tiket);
        }).orElseGet(() -> {
            newTiket.setId(id);
            return tiketService.saveTiket(newTiket);
        });
    }
}

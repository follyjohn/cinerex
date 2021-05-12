package org.hermit.cinerex.salle.controller;

import java.util.Optional;

import org.hermit.cinerex.salle.model.Place;
import org.hermit.cinerex.salle.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {
    
    @Autowired
    private PlaceService placeService;

    @GetMapping("/places")
    public Iterable<Place> getAllPlace() {
        return placeService.getAllPlace();
    }

    @PostMapping("/places")
    public String createPlace(@RequestBody Place place) {
        placeService.savePlace(place);
        return "Place enregistre";
    }

    @GetMapping(value = "places/{id}")
    public Place getPlace(@PathVariable Long id) {
        Optional<Place> place = placeService.getPlace(id);
        if (place.isPresent()) {
            return place.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "places/{id}")
    public String deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return "Place supprime";
    }

    @PutMapping(value = "places/{id}")
    public Place putPlace(@PathVariable Long id, @RequestBody Place newPlace) {
        return placeService.getPlace(id).map(place -> {
            place.setNumero(newPlace.getNumero());
            place.setLatitude(newPlace.getLatitude());
            place.setLongitude(newPlace.getLongitude());
            return placeService.savePlace(place);
        }).orElseGet(() -> {
            newPlace.setId(id);
            return placeService.savePlace(newPlace);
        });
    }
}

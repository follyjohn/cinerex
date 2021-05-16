package org.hermit.cinerex.controller;

import java.util.Optional;

import org.hermit.cinerex.model.Place;
import org.hermit.cinerex.service.PlaceService;
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
public class PlaceController {
    
    @Autowired
    private PlaceService placeService;

    
    /** 
     * @return Iterable<Place>
     */
    @GetMapping("/places")
    public Iterable<Place> getAllPlace() {
        return placeService.getAllPlace();
    }

    
    /** 
     * @param place
     * @return String
     */
    @PostMapping("/places")
    public String createPlace(@RequestBody Place place) {
        placeService.savePlace(place);
        return "Place enregistre";
    }

    
    /** 
     * @param id
     * @return Place
     */
    @GetMapping(value = "places/{id}")
    public Place getPlace(@PathVariable Long id) {
        Optional<Place> place = placeService.getPlace(id);
        if (place.isPresent()) {
            return place.get();
        } else {
            return null;
        }
    }

    
    /** 
     * @param id
     * @return String
     */
    @DeleteMapping(value = "places/{id}")
    public String deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return "Place supprime";
    }

    
    /** 
     * @param id
     * @param newPlace
     * @return Place
     */
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

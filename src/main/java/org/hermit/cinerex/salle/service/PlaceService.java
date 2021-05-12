package org.hermit.cinerex.salle.service;

import java.util.Optional;

import org.hermit.cinerex.salle.model.Place;
import org.hermit.cinerex.salle.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository placeRepository;

    public Optional<Place> getPlace(final Long id) {
        return placeRepository.findById(id);
    }

    public Iterable<Place> getAllPlace() {
        return placeRepository.findAll();
    }

    public void deletePlace(final Long id) {
        placeRepository.deleteById(id);
    }

    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }
}

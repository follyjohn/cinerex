package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Place;
import org.hermit.cinerex.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository placeRepository;

    
    /** 
     * @param id
     * @return Optional<Place>
     */
    public Optional<Place> getPlace(final Long id) {
        return placeRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Place>
     */
    public Iterable<Place> getAllPlace() {
        return placeRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deletePlace(final Long id) {
        placeRepository.deleteById(id);
    }

    
    /** 
     * @param place
     * @return Place
     */
    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }
}

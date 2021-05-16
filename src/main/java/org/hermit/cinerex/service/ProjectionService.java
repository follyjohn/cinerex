package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Projection;
import org.hermit.cinerex.repository.ProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionService {
    
    @Autowired
    private ProjectionRepository projectionRepository;

    
    /** 
     * @param id
     * @return Optional<Projection>
     */
    public Optional<Projection> getProjection(final Long id) {
        return projectionRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Projection>
     */
    public Iterable<Projection> getAllProjection() {
        return projectionRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteProjection(final Long id) {
        projectionRepository.deleteById(id);
    }

    
    /** 
     * @param projection
     * @return Projection
     */
    public Projection saveProjection(Projection projection) {
        return projectionRepository.save(projection);
    }
}

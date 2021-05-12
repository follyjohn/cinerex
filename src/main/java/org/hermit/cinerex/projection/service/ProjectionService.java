package org.hermit.cinerex.projection.service;

import java.util.Optional;

import org.hermit.cinerex.projection.model.Projection;
import org.hermit.cinerex.projection.repository.ProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionService {
    
    @Autowired
    private ProjectionRepository projectionRepository;

    public Optional<Projection> getProjection(final Long id) {
        return projectionRepository.findById(id);
    }

    public Iterable<Projection> getAllProjection() {
        return projectionRepository.findAll();
    }

    public void deleteProjection(final Long id) {
        projectionRepository.deleteById(id);
    }

    public Projection saveProjection(Projection projection) {
        return projectionRepository.save(projection);
    }
}

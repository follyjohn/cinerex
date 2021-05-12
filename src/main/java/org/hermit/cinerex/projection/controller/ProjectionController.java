package org.hermit.cinerex.projection.controller;

import java.util.Optional;

import org.hermit.cinerex.projection.model.Projection;
import org.hermit.cinerex.projection.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectionController {
    
    @Autowired
    private ProjectionService projectionService;

    @GetMapping("/projections")
    public Iterable<Projection> getAllProjection() {
        return projectionService.getAllProjection();
    }

    @PostMapping("/projections")
    public String createProjection(@RequestBody Projection projection) {
        projectionService.saveProjection(projection);
        return "Projection enregistre";
    }

    @GetMapping(value = "projections/{id}")
    public Projection getProjection(@PathVariable Long id) {
        Optional<Projection> projection = projectionService.getProjection(id);
        if (projection.isPresent()) {
            return projection.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "projections/{id}")
    public String deleteProjection(@PathVariable Long id) {
        projectionService.deleteProjection(id);
        return "Projection supprime";
    }

    @PutMapping(value = "projections/{id}")
    public Projection putProjection(@PathVariable Long id, @RequestBody Projection newProjection) {
        return projectionService.getProjection(id).map(projection -> {
            projection.setFilm(newProjection.getFilm());
            projection.setSale(newProjection.getSale());
            projection.setSeance(newProjection.getSeance());
            projection.setPrix(newProjection.getPrix());
            projection.setDateProjection(newProjection.getDateProjection());
            return projectionService.saveProjection(projection);
        }).orElseGet(() -> {
            newProjection.setId(id);
            return projectionService.saveProjection(newProjection);
        });
    }
}

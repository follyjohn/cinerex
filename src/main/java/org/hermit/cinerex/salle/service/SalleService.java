package org.hermit.cinerex.salle.service;

import java.util.Optional;

import org.hermit.cinerex.salle.model.Salle;
import org.hermit.cinerex.salle.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    public Optional<Salle> getSalle(final Long id) {
        return salleRepository.findById(id);
    }

    public Iterable<Salle> getAllSalle() {
        return salleRepository.findAll();
    }

    public void deleteSalle(final Long id) {
        salleRepository.deleteById(id);
    }

    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }
}

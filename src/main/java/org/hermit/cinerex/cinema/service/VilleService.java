package org.hermit.cinerex.cinema.service;

import java.util.Optional;

import org.hermit.cinerex.cinema.model.Ville;
import org.hermit.cinerex.cinema.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleService {
    
    @Autowired
    private VilleRepository villeRepository;

    public Optional<Ville> getVille(final long id) {
        return villeRepository.findById(id);
    }

    public Iterable<Ville> getAllVille() {
        return villeRepository.findAll();
    }

    public void deleteVille(final long id) {
        villeRepository.deleteById(id);
    }

    public Ville saveVille(Ville ville) {
        return  villeRepository.save(ville);
    }
}

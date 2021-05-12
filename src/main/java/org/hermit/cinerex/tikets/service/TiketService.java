package org.hermit.cinerex.tikets.service;

import java.util.Optional;

import org.hermit.cinerex.tikets.model.Tiket;
import org.hermit.cinerex.tikets.repository.TiketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiketService {
    
    @Autowired
    private TiketRepository tiketRepository;

    public Optional<Tiket> getTiket(final Long id) {
        return tiketRepository.findById(id);
    }

    public Iterable<Tiket> getAllTiket() {
        return tiketRepository.findAll();
    }

    public void deleteTiket(final Long id) {
        tiketRepository.deleteById(id);
    }

    public Tiket saveTiket(Tiket tiket) {
        return tiketRepository.save(tiket);
    }
}

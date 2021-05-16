package org.hermit.cinerex.service;

import java.util.Optional;

import org.hermit.cinerex.model.Categorie;
import org.hermit.cinerex.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    
    @Autowired
    private CategorieRepository categorieRepository;

    public Optional<Categorie> getCategorie(final Long id) {
        return categorieRepository.findById(id);
    }

    public Iterable<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    public void deleteCategorie(final Long id) {
        categorieRepository.deleteById(id);
    }

    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }
}

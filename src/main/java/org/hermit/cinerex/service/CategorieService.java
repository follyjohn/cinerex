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

    
    /** 
     * @param id
     * @return Optional<Categorie>
     */
    public Optional<Categorie> getCategorie(final Long id) {
        return categorieRepository.findById(id);
    }

    
    /** 
     * @return Iterable<Categorie>
     */
    public Iterable<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    
    /** 
     * @param id
     */
    public void deleteCategorie(final Long id) {
        categorieRepository.deleteById(id);
    }

    
    /** 
     * @param categorie
     * @return Categorie
     */
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }
}

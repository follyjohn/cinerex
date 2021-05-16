package org.hermit.cinerex.controller;

import java.util.Optional;

import org.hermit.cinerex.model.Categorie;
import org.hermit.cinerex.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    
    /** 
     * @return Iterable<Categorie>
     */
    @GetMapping("/categories")
    public Iterable<Categorie> getAllCategorie() {
        return categorieService.getAllCategorie();
    }

    
    /** 
     * @param categories
     * @return String
     */
    @PostMapping("/categories")
    public String createCategorie(@RequestBody Categorie categories) {
        categorieService.saveCategorie(categories);
        return "Categorie enregistre";
    }

    
    /** 
     * @param id
     * @return Categorie
     */
    @GetMapping(value = "categories/{id}")
    public Categorie getCategorie(@PathVariable Long id) {
        Optional<Categorie> categories = categorieService.getCategorie(id);
        if (categories.isPresent()) {
            return categories.get();
        } else {
            return null;
        }
    }

    
    /** 
     * @param id
     * @return String
     */
    @DeleteMapping(value = "categories/{id}")
    public String deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
        return "Categorie supprime";
    }

    
    /** 
     * @param id
     * @param newCategorie
     * @return Categorie
     */
    @PutMapping(value = "categories/{id}")
    public Categorie putCategorie(@PathVariable Long id, @RequestBody Categorie newCategorie) {
        return categorieService.getCategorie(id).map(categories -> {
            categories.setName(newCategorie.getName());
            return categorieService.saveCategorie(categories);
        }).orElseGet(() -> {
            newCategorie.setId(id);
            return categorieService.saveCategorie(newCategorie);
        });
    }
    
}

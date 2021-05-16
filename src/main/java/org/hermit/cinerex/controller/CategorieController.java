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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    public Iterable<Categorie> getAllCategorie() {
        return categorieService.getAllCategorie();
    }

    @PostMapping("/categories")
    public String createCategorie(@RequestBody Categorie categories) {
        categorieService.saveCategorie(categories);
        return "Categorie enregistre";
    }

    @GetMapping(value = "categories/{id}")
    public Categorie getCategorie(@PathVariable Long id) {
        Optional<Categorie> categories = categorieService.getCategorie(id);
        if (categories.isPresent()) {
            return categories.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "categories/{id}")
    public String deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
        return "Categorie supprime";
    }

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

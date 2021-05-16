package org.hermit.cinerex.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="films")
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titre;

    private double duree;

    private String realisateur;

    private String description;

    private String photo;

    private Date dateSortie;

    @ManyToOne
    private Categorie categorie;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Film() {
    }

    public Film(Long id, String titre, double duree, String realisateur, String description, String photo,
            Date dateSortie, Categorie categorie) {
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.realisateur = realisateur;
        this.description = description;
        this.photo = photo;
        this.dateSortie = dateSortie;
        this.categorie = categorie;
    }

    public Film(String titre, double duree, String realisateur, String description, String photo, Date dateSortie,
            Categorie categorie) {
        this.titre = titre;
        this.duree = duree;
        this.realisateur = realisateur;
        this.description = description;
        this.photo = photo;
        this.dateSortie = dateSortie;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
}

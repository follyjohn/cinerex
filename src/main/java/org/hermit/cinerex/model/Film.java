package org.hermit.cinerex.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="films")
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String titre;

    private double duree;

    private String realisateur;

    private String description;

    private String photo;

    private Date dateSortie;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "film")
    private Collection<Projection> projections;

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

    
    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getTitre() {
        return titre;
    }

    
    /** 
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    
    /** 
     * @return double
     */
    public double getDuree() {
        return duree;
    }

    
    /** 
     * @param duree
     */
    public void setDuree(double duree) {
        this.duree = duree;
    }

    
    /** 
     * @return String
     */
    public String getRealisateur() {
        return realisateur;
    }

    
    /** 
     * @param realisateur
     */
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    
    /** 
     * @return String
     */
    public String getDescription() {
        return description;
    }

    
    /** 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    /** 
     * @return String
     */
    public String getPhoto() {
        return photo;
    }

    
    /** 
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    /** 
     * @return Date
     */
    public Date getDateSortie() {
        return dateSortie;
    }

    
    /** 
     * @param dateSortie
     */
    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    
    /** 
     * @return Categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    
    /** 
     * @param categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
}

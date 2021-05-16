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
@Table(name = "projections")
public class Projection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateProjection;

    private double prix;

    @NotNull
    @ManyToOne
    private Film film;

    @ManyToOne
    private Salle salle;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "projection")
    private Collection<Tiket> tikets;

    @ManyToOne
    private Seance seance;

    public Projection() {
    }

    public Projection(Date dateProjection, double prix, Film film, Salle salle, Seance seance) {
        this.dateProjection = dateProjection;
        this.prix = prix;
        this.film = film;
        this.salle = salle;
        this.seance = seance;
    }

    public Projection(Long id, Date dateProjection, double prix, Film film, Salle salle, Seance seance) {
        this.id = id;
        this.dateProjection = dateProjection;
        this.prix = prix;
        this.film = film;
        this.salle = salle;
        this.seance = seance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateProjection() {
        return dateProjection;
    }

    public void setDateProjection(Date dateProjection) {
        this.dateProjection = dateProjection;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Salle getSale() {
        return salle;
    }

    public void setSale(Salle salle) {
        this.salle = salle;
    }

    public Collection<Tiket> getTikets() {
        return tikets;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

}

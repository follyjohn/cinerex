package org.hermit.cinerex.model;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
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
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @Column(nullable = false)
    private int nombrePlace;

    @ManyToOne
    private Cinema cinema;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "salle")
    private Collection<Place> places;

    @OneToMany(mappedBy = "salle")
    private Collection<Projection> projections;


    public Salle() {
    }

    public Salle(Long id, String name, int nombrePlace, Cinema cinema) {
        this.id = id;
        this.name = name;
        this.nombrePlace = nombrePlace;
        this.cinema = cinema;
    }

    public Salle(String name, int nombrePlace, Cinema cinema) {
        this.name = name;
        this.nombrePlace = nombrePlace;
        this.cinema = cinema;
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
    public String getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return int
     */
    public int getNombreSalles() {
        return nombrePlace;
    }

    
    /** 
     * @param nombrePlace
     */
    public void setNombreSalles(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    
    /** 
     * @return Cinema
     */
    public Cinema getCinema() {
        return cinema;
    }

    
    /** 
     * @param cinema
     */
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    
}

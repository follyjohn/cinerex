package org.hermit.cinerex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int nombrePlace;

    @ManyToOne
    private Cinema cinema;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNombreSalles() {
        return nombrePlace;
    }

    public void setNombreSalles(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    
}

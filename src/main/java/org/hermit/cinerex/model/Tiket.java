package org.hermit.cinerex.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tikets")
public class Tiket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomClient;

    private double prix;

    @Column(unique = true)
    private int codePayement;

    private boolean reserve;

    @ManyToOne
    private Place place;

    @ManyToOne
    private Projection projection;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Tiket() {
    }

    public Tiket(String nomClient, double prix, int codePayement, boolean reserve, Place place, Projection projection) {
        this.nomClient = nomClient;
        this.prix = prix;
        this.codePayement = codePayement;
        this.reserve = reserve;
        this.place = place;
        this.projection = projection;
    }

    public Tiket(Long id, String nomClient, double prix, int codePayement, boolean reserve, Place place,
            Projection projection) {
        this.id = id;
        this.nomClient = nomClient;
        this.prix = prix;
        this.codePayement = codePayement;
        this.reserve = reserve;
        this.place = place;
        this.projection = projection;
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
    public String getNomClient() {
        return nomClient;
    }

    
    /** 
     * @param nomClient
     */
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    
    /** 
     * @return double
     */
    public double getPrix() {
        return prix;
    }

    
    /** 
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    
    /** 
     * @return int
     */
    public int getCodePayement() {
        return codePayement;
    }

    
    /** 
     * @param codePayement
     */
    public void setCodePayement(int codePayement) {
        this.codePayement = codePayement;
    }

    
    /** 
     * @return boolean
     */
    public boolean isReserve() {
        return reserve;
    }

    
    /** 
     * @param reserve
     */
    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    
    /** 
     * @return Place
     */
    public Place getPlace() {
        return place;
    }

    
    /** 
     * @param place
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    
    /** 
     * @return Projection
     */
    public Projection getProjection() {
        return projection;
    }

    
    /** 
     * @param projection
     */
    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    
}

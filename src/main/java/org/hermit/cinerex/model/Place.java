package org.hermit.cinerex.model;

import java.time.LocalDateTime;
import java.util.Collection;

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
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private int numero;

    private double longitude;

    private double latitude;

    @OneToMany(mappedBy = "place")
    private Collection<Tiket> tikets;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    private Salle salle;
    
    public Place() {
    }

    public Place(Long id, int numero, double longitude, double latitude, Salle salle) {
        this.id = id;
        this.numero = numero;
        this.longitude = longitude;
        this.latitude = latitude;
        this.salle = salle;
    }

    public Place(int numero, double longitude, double latitude, Salle salle) {
        this.numero = numero;
        this.longitude = longitude;
        this.latitude = latitude;
        this.salle = salle;
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
     * @return int
     */
    public int getNumero() {
        return numero;
    }

    
    /** 
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    /** 
     * @return double
     */
    public double getLongitude() {
        return longitude;
    }

    
    /** 
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    
    /** 
     * @return double
     */
    public double getLatitude() {
        return latitude;
    }

    
    /** 
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    
    /** 
     * @param createdAt
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    
    /** 
     * @param updatedAt
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    
}

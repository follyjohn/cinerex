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
@Table(name="cinemas")
public class Cinema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private double longitude;

    private double latitude;

    private double altitude;

    @NotNull
    private int nombreSalles;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;

    @ManyToOne
    private Ville ville;

    public Cinema() {
    }

    public Cinema(Long id, String name, double longitude, double latitude, double altitude, int nombreSalles,
            Ville ville) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.nombreSalles = nombreSalles;
        this.ville = ville;
    }

    public Cinema(String name, double longitude, double latitude, double altitude, int nombreSalles, Ville ville) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.nombreSalles = nombreSalles;
        this.ville = ville;
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
     * @return double
     */
    public double getAltitude() {
        return altitude;
    }

    
    /** 
     * @param altitude
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    
    /** 
     * @return int
     */
    public int getNombreSalles() {
        return nombreSalles;
    }

    
    /** 
     * @param nombreSalles
     */
    public void setNombreSalles(int nombreSalles) {
        this.nombreSalles = nombreSalles;
    }

    
    /** 
     * @return Ville
     */
    public Ville getVille() {
        return ville;
    }

    
    /** 
     * @param ville
     */
    public void setVille(Ville ville) {
        this.ville = ville;
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

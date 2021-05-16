package org.hermit.cinerex.model;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * Ville
 */

@Entity
@Table(name = "villes")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private double longitude;

    @NotNull
    private double latitude;

    @NotNull
    private double altitude;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "ville")
    private Collection<Cinema> cinemas;

    public Ville() {
    }

    public Ville(Long id, String name, double longitude, double latitude, double altitude) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    public Ville(String name, double longitude, double latitude, double altitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
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
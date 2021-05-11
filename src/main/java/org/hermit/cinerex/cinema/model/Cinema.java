package org.hermit.cinerex.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cinemas")
public class Cinema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double longitude;

    private double latitude;

    private double altitude;


    @Column(name="nombre_salle")
    private int nombreSalles;

    
    public Cinema(Long id, String name, double longitude, double latitude, double altitude, 
            int nombreSalles) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.nombreSalles = nombreSalles;
    }
    public Cinema() {
    }

    

    public Cinema(String name, double longitude, double latitude, double altitude, int nombreSalles) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.nombreSalles = nombreSalles;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public int getNombreSalles() {
        return nombreSalles;
    }

    public void setNombreSalles(int nombreSalles) {
        this.nombreSalles = nombreSalles;
    }


}

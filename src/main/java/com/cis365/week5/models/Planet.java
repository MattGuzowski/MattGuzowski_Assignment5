package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "PLANET")
public class Planet {

    public Planet() {}

    @Id
    @Column(name = "PLANETID")
    private String planetId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RADIUS")
    private String radius;

    @Column(name = "ATMOSPHERE")
    private String atmosphere;

    public Planet(String planetIDIn, String nameIn, String radiusIn, String atmosphereIn) {

        this.planetId = planetIDIn;
        this.name = nameIn;
        this.radius = radiusIn;
        this.atmosphere = atmosphereIn;
    }

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

}

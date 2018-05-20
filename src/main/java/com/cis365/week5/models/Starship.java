package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "STARHIP")
public class Starship {

    public Starship() {
    }

    @Id
    @Column(name = "STARSHIPID")
    private String starShipId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREWSIZE")
    private String crewSize;

    @Column(name = "SHIPCLASS")
    private String shipClass;

    @Column(name = "LAUNCHSTARDATE")
    private String launchStardate;

    public String getStarShipId() {
        return starShipId;
    }

    public void setStarShipId(String starShipId) {
        this.starShipId = starShipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(String crewSize) {
        this.crewSize = crewSize;
    }

    public String getShipClass() {
        return shipClass;
    }

    public void setShipClass(String shipClass) {
        this.shipClass = shipClass;
    }

    public String getLaunchStardate() {
        return launchStardate;
    }

    public void setLaunchStardate(String launchStardate) {
        this.launchStardate = launchStardate;
    }
}

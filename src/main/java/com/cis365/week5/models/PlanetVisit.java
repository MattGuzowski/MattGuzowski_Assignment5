package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "PLANETVISIT")
public class PlanetVisit {

    public PlanetVisit() {
    }
    
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "VISITCOUNT")
    private int visitCount;
    
    @Column(name = "PLANETID")
    private int planetId;

    @Column(name = "STARSHIPID")
    private int starshipID;

    @Column(name = "ARRIVALSTARDATE")
    private int arrivalStardate;

    @Column(name = "DEPARTURESTARDATE")
    private int departureStardate;

    public int getVisitCount(){
        return visitCount;
    }
    
    public void setVisitCount(int visitCountIn){
        this.visitCount = visitCountIn;
    }
    public int getPlanetId() {
        return planetId;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }

    public int getStarshipID() {
        return starshipID;
    }

    public void setStarshipID(int starshipID) {
        this.starshipID = starshipID;
    }

    public int getArrivalStardate() {
        return arrivalStardate;
    }

    public void setArrivalStardate(int arrivalStardate) {
        this.arrivalStardate = arrivalStardate;
    }

    public int getDepartureStardate() {
        return departureStardate;
    }

    public void setDepartureStardate(int departureStardate) {
        this.departureStardate = departureStardate;
    }

}

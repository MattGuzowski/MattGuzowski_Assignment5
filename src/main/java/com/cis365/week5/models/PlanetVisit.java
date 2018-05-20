
package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name="PLANETVISIT")
public class PlanetVisit {
    
    public PlanetVisit(){}
    
    @Id //id as primary key
    @Column(name = "PLANETID")
    private String planetId;
    
    @Id
    @Column(name = "STARSHIPID")
    private String starshipID;
    
    @Id
    @Column(name = "ARRIVALSTARDATE")
    private String arrivalStardate;
    
    @Column(name = "DEPARTURESTARDATE")
        private String departureStardate;

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }

    public String getStarshipID() {
        return starshipID;
    }

    public void setStarshipID(String starshipID) {
        this.starshipID = starshipID;
    }

    public String getArrivalStardate() {
        return arrivalStardate;
    }

    public void setArrivalStardate(String arrivalStardate) {
        this.arrivalStardate = arrivalStardate;
    }

    public String getDepartureStardate() {
        return departureStardate;
    }

    public void setDepartureStardate(String departureStardate) {
        this.departureStardate = departureStardate;
    }
    
}

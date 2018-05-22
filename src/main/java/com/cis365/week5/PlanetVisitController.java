package com.cis365.week5;

import com.cis365.week5.models.PlanetVisit;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
public class PlanetVisitController {

    @GetMapping("/visit")
    public List<PlanetVisit> visits() {
        return DataStore.listVisits();
    }
       
    //add new visit
     @PostMapping(value = "/visit/{{planetId}", consumes = {MediaType.APPLICATION_JSON_VALUE})

    public void addVisit(@PathVariable(value = "planetId") int planetId,@RequestBody PlanetVisit visitToUpdate){
        DataStore.addVisit(planetId, visitToUpdate);
    }
}


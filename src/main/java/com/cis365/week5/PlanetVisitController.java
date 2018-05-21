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
//    @PostMapping(value = "/visit/{{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
//
//    public PlanetVisit addVisit(@PathVariable(value = "planetId") String planetId,@RequestBody PlanetVisit visitToUpdate){
//        return DataStore.updateVisit(planetId, visitToUpdate);
}


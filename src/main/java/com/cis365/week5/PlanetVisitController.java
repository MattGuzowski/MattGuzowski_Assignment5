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
    @GetMapping("/visit/{visitCount}")
    public PlanetVisit getPlanetVisit(@PathVariable(value="visitCount") int visitCount) {
        return DataStore.findVisitByVisitCount(visitCount);
    }

     @PostMapping(value = "/visit/{visitCount}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public PlanetVisit addVisit(@PathVariable(value = "visitCount")int visitCount, @RequestBody PlanetVisit visitToAdd){
        return DataStore.addVisit(visitCount, visitToAdd);
    }
}


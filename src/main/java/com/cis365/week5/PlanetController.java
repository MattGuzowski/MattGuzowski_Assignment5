package com.cis365.week5;

import com.cis365.week5.models.Planet;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
public class PlanetController {

    @GetMapping("/planet")
    public List<Planet> planets() {
        return DataStore.listPlanets();
    }

    @GetMapping("/planet/{planetId}")
    public Planet getPlanetById(@PathVariable(value="planetId")int planetId) {
        return DataStore.findPlanetById(planetId);
    }

    @PostMapping(value = "/planet/{planetId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Planet addPlanet(@PathVariable(value = "planetId") int planetId, @RequestBody Planet planetToAdd) {
        return DataStore.addPlanet(planetId, planetToAdd);
    }

    @PutMapping(value = "/planet/{planetId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updatePlanet(@PathVariable(value = "planetId") int planetId, @RequestBody Planet planetToUpdate){
        DataStore.updatePlanet(planetId, planetToUpdate);
    }
    
    @DeleteMapping("/planet/{planetId}")
    public void deletePlanet(@PathVariable(value = "planetId") int planetId) {
        DataStore.deletePlanet(planetId);
    }
}

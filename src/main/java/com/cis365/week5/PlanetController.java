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

    @GetMapping("/planet/{id}")
    public Planet getPlanetById(int planetId) {
        return DataStore.findPlanetById(planetId);
    }

    @PostMapping(value = "/planet/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Planet addPlanet(@PathVariable(value = "planetId") int planetId, @RequestBody Planet planetToUpdate) {
        return DataStore.updatePlanet(planetId, planetToUpdate);
    }
}

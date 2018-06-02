package com.cis365.week5;

import com.cis365.week5.models.Starship;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarshipController {

    @GetMapping("/starship")
    public List<Starship> starship() {
        return DataStore.listStarships();
    }

    @GetMapping("/starship/{starshipId}")
    public Starship getStarship(@PathVariable(value = "starshipid") int starshipId) {
        return DataStore.findStarshipById(starshipId);
    }

    @PostMapping(value = "/starship/{starshipId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addStarship(@PathVariable(value = "starshipId") int starshipId, @RequestBody Starship starshipToAdd) {
        DataStore.addStarship(starshipId, starshipToAdd);
    }

    @PutMapping(value = "/starship/{starshipId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateStarship(@PathVariable(value = "starshipId") int starshipId, @RequestBody Starship starshipToUpdate) {
        DataStore.updateStarship(starshipId, starshipToUpdate);
    }

    @DeleteMapping("/starship/{starshipId}")
    public void deleteStarship(@PathVariable(value = "starshipId") int starshipId) {
        DataStore.deleteStarship(starshipId);
    }
}


package com.cis365.week5;

import com.cis365.week5.models.Starship;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class StarshipController {
    
    @GetMapping("/starship")
    public List<Starship> starship(){
        return DataStore.listStarships();
    }
    //find
    @GetMapping("/startip/{starshipId}")
    public Starship getStarship(int starshipId){
        return DataStore.findStarshipById(starshipId);
    }
    
    @PostMapping(value = "/starship/{starhipId}", consumes ={MediaType.APPLICATION_JSON_VALUE})
    public void addStarship(@PathVariable(value = "starshipId") int starshipId, @RequestBody Starship starshipToAdd){
        DataStore.addStarship(starshipId, starshipToAdd);
    }
    //delete
    @DeleteMapping("/starship/{starshipId}")
    public void deleteStarship(@PathVariable(value = "starshipId") int starshipId){
        DataStore.deletePlanet(starshipId);
    }
    
    //update
    
}

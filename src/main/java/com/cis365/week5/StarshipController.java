
package com.cis365.week5;

import com.cis365.week5.models.Starship;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


public class StarshipController {
    
    @GetMapping("/starship")
    public List<Starship> starship(){
        return DataStore.listStarships();
    }
    //find
    
    //delete
    
    //update
    
}

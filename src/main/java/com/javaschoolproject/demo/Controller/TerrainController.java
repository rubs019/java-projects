package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Terrain;
import com.javaschoolproject.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/terrain")
public class TerrainController {
    @Autowired
    private TerrainRepository terrainRepository;

    @PostMapping()
    public @ResponseBody String addNewTerrain (@RequestBody Terrain administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Terrain n = new Terrain();
        n.setNom("Nom");
        n.setLocalisation("14 Avenue Louis Pasteur");
        terrainRepository.save(n);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Terrain> getAllTerrain(){
        return terrainRepository.findAll();
    }
}
package com.javaschoolproject.demo.Administrator;

import com.javaschoolproject.demo.domaine.Terrain;
import com.javaschoolproject.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/terrain")
public class TerrainController {
    @Autowired
    private TerrainRepository terrainRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewTerrain (@RequestBody Terrain administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Terrain n = new Terrain();
        n.setNom("Nom");
        n.setLocalisation("14 Avenue Louis Pasteur");
        terrainRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Terrain> getAllAdministrator(){
        return terrainRepository.findAll();
    }
}
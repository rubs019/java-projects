package com.javaschoolproject.demo.Administrator;

import com.javaschoolproject.demo.domaine.Terrain;
import com.javaschoolproject.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/terrain")
public class PartieController {
    @Autowired
    private PartieRepository partieRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewPartie (@RequestBody Partie administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Partie p = new Partie();
        p.setNom("Nom");
        p.setDate("27/02/1995");
        p.setPlace(40);
        p.setStock(1);
        terrainRepository.save(p);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Partie> getAllAdministrator(){
        return terrainRepository.findAll();
    }
}
package com.javaschoolproject.demo.Administrator;

import com.javaschoolproject.demo.domaine.Terrain;
import com.javaschoolproject.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/replique")
public class RepliqueController {
    @Autowired
    private RepliqueRepository repliqueRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewReplique (@RequestBody Replique administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Replique r = new Replique();
        r.setNom("Nom");
        repliqueRepository.save(r);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Replique> getAllReplique(){
        return repliqueRepository.findAll();
    }
}
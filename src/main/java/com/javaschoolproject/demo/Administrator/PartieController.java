package com.javaschoolproject.demo.Administrator;

import com.javaschoolproject.demo.domaine.Partie;
import com.javaschoolproject.demo.repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(path="/partie")
public class PartieController {
    @Autowired
    private PartieRepository partieRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewPartie (@RequestBody Partie administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Partie partie = new Partie();
        partie.setNom("Nom");
        partie.setDate(new Date(716940000));
        partie.setPlace(40);
        partie.setStock(1);
        partieRepository.save(partie);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Partie> getAllPartie(){
        return partieRepository.findAll();
    }
}
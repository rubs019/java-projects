package com.javaschoolproject.demo.Administrator;

import com.javaschoolproject.demo.domaine.Terrain;
import com.javaschoolproject.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user_partie")
public class RepliqueController {
    @Autowired
    private User_partieRepository user_partieRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewUser_partie (@RequestBody User_partie administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User_partie u = new User_partie();
        u.id_user(1);
        u.id_partie(1;
        user_partieRepository.save(u);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User_partie> getAllUser_partie(){
        return stockUser_partie.findAll();
    }
}
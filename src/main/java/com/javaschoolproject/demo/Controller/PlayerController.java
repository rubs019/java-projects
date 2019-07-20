package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping()
    public String addNewTerrain (@RequestBody Player administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Player player = new Player();
        player.setNom("Nom");
        player.setPrenom("test");
        player.setUsername("player");
        player.setPassword("mdp");
        player.setEmail("camarche@camarche.com");
        playerRepository.save(player);
        return "Saved";
    }

    @GetMapping()
    public Iterable<Player> getAllUser(){
        return playerRepository.findAll();
    }
}
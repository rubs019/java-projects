package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Player> addNewPlayer (@Valid @RequestBody Player player, HttpServletRequest request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Player createdPlayer = playerService.createPlayer(player);
        URI location = URI.create(request.getRequestURL().append("/").append(createdPlayer.getId()).toString());
        return ResponseEntity.created(location).body(createdPlayer);
    }

    @GetMapping()
    public Iterable<Player> getAllUser(){
        return playerService.findAllPlayer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        Optional<Player> foundPlayer = playerService.findPlayerById(Integer.parseInt(id));
        if(!foundPlayer.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundPlayer.get());
    }
}
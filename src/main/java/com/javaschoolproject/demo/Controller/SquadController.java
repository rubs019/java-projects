package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.models.Squad;
import com.javaschoolproject.demo.repository.PlayerRepository;
import com.javaschoolproject.demo.services.PlayerService;
import com.javaschoolproject.demo.services.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/squads")
public class SquadController {
    @Autowired
    private SquadService squadService;
    @Autowired
    private PlayerService playerService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Squad> addNewSquad (@Valid @RequestBody Squad squad, HttpServletRequest request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Squad createdSquad = squadService.createSquad(squad);
        URI location = URI.create(request.getRequestURL().append("/").append(createdSquad.getId()).toString());
        return ResponseEntity.created(location).body(createdSquad);
    }

    @GetMapping()
    public Iterable<Squad> getAllSquads(){
        return squadService.findAllSquad();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Squad> getSquadById(@PathVariable String id) {
        Optional<Squad> foundSquad = squadService.findSquadById(Integer.parseInt(id));
        if(!foundSquad.isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(foundSquad.get());
    }

    @DeleteMapping("/{id}")
    public void deleteSquad(@PathVariable String id) {
        squadService.deleteSquad(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Squad> updateSquadById(@RequestBody Squad squad, @PathVariable String id) {
        Optional<Squad> foundSquad = squadService.findSquadById(Integer.parseInt(id));
        if(!foundSquad.isPresent()){
            return ResponseEntity.notFound().build();
        }
        squad.setId(foundSquad.get().getId());
        squadService.updateSquad(squad);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<Set<Player>> getPlayers(@PathVariable String id) {
        Optional<Squad> foundSquad = squadService.findSquadById(Integer.parseInt(id));
        if(!foundSquad.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundSquad.get().getPlayers());
    }

    @PostMapping("/{id}/players")
    public ResponseEntity<Squad> addNewPlayer(@Valid @RequestBody Player player, HttpServletRequest request, @PathVariable String id) {
        Optional<Squad> foundSquad = squadService.findSquadById(Integer.parseInt(id));
        if(!foundSquad.isPresent()){
            return ResponseEntity.notFound().build();
        }

        player.setSquad(foundSquad.get());
        playerService.updatePlayer(player);
        return ResponseEntity.ok(foundSquad.get());
    }

}

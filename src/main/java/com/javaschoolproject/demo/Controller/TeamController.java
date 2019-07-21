package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Squad;
import com.javaschoolproject.demo.models.Team;
import com.javaschoolproject.demo.services.SquadService;
import com.javaschoolproject.demo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @Autowired
    SquadService squadService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Team> addNewTeam (@Valid @RequestBody Team squad, HttpServletRequest request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Team createdTeam = teamService.createTeam(squad);
        URI location = URI.create(request.getRequestURL().append("/").append(createdTeam.getId()).toString());
        return ResponseEntity.created(location).body(createdTeam);
    }

    @GetMapping()
    public Iterable<Team> getAllTeams(){
        return teamService.findAllTeam();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable String id) {
        Optional<Team> foundTeam = teamService.findTeamById(Integer.parseInt(id));
        if(!foundTeam.isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(foundTeam.get());
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable String id) {
        teamService.deleteTeam(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeamById(@RequestBody Team squad, @PathVariable String id) {
        Optional<Team> foundTeam = teamService.findTeamById(Integer.parseInt(id));
        if(!foundTeam.isPresent()){
            return ResponseEntity.notFound().build();
        }
        squad.setId(foundTeam.get().getId());
        teamService.updateTeam(squad);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/squads")
    public ResponseEntity<Set<Squad>> getSquads(@PathVariable String id) {
        Optional<Team> foundTeam = teamService.findTeamById(Integer.parseInt(id));
        if(!foundTeam.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundTeam.get().getSquads());
    }

    @PostMapping("/{id}/squads")
    public ResponseEntity<Team> addNewSquad(@Valid @RequestBody Squad squad, HttpServletRequest request, @PathVariable String id) {
        Optional<Team> foundTeam = teamService.findTeamById(Integer.parseInt(id));
        if(!foundTeam.isPresent()){
            return ResponseEntity.notFound().build();
        }

        squad.setTeam(foundTeam.get());
        squadService.updateSquad(squad);
        return ResponseEntity.ok(foundTeam.get());
    }
}

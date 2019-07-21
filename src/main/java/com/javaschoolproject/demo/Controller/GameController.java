package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Game;
import com.javaschoolproject.demo.services.GameService;
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
@RequestMapping(path = "/games")
public class GameController {
    private GameService gameService;

    @Autowired
    public void GameService(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Game> addNewGame (@Valid @RequestBody Game game, HttpServletRequest request) {
        Game createdDay = gameService.createGame(game);
        URI location = URI.create(request.getRequestURL().append("/").append(createdDay.getId()).toString());
        return ResponseEntity.created(location).body(createdDay);
    }

    @GetMapping()
    public Iterable<Game> getAllGames(){
        return gameService.findAllGame();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable String id) {
        Optional<Game> foundGame = gameService.findGameById(Integer.parseInt(id));
        if(!foundGame.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundGame.get());
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameService.deleteGame(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateSquadById(@RequestBody Game game, @PathVariable String id) {
        Optional<Game> foundGame = gameService.findGameById(Integer.parseInt(id));
        if(!foundGame.isPresent()){
            return ResponseEntity.notFound().build();
        }
        game.setId(foundGame.get().getId());
        gameService.updateGame(game);
        return ResponseEntity.noContent().build();
    }

}
package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Game;
import com.javaschoolproject.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/partie")
public class GameController {
    private GameService gameService;

    @Autowired
    public void PartieService(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void createPartie(@Valid @RequestBody Game game, HttpServletResponse response, HttpServletRequest request) {

        Game createdGame = gameService.createPartie(game);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdGame.getId()).toString());
    }

    @GetMapping()
    public Iterable<Game> getAllPartie() {
        return gameService.findAllPartie();
    }
}
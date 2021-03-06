package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Game;
import com.javaschoolproject.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public void GameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(Game game){
        return gameRepository.save(game);
    }

    public Iterable<Game> findAllGame() {
        return gameRepository.findAll();
    }

    public Optional<Game> findGameById(Integer id) {
        return gameRepository.findById(id);
    }

    public void deleteGame(Integer id){
        gameRepository.deleteById(id);
    }

    public void updateGame(Game game){
        gameRepository.save(game);
    }

}

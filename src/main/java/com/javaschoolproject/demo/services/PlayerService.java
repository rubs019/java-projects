package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player game) {
        return playerRepository.save(game);
    }

    public Iterable<Player> findAllPlayer() {
        return playerRepository.findAll();
    }

    public Optional<Player> findPlayerById(Integer id) {
        return playerRepository.findById(id);
    }
    public void deletePlayer(Integer id){
        playerRepository.deleteById(id);
    }
    public void updatePlayer(Player player){
        playerRepository.save(player);
    }
}

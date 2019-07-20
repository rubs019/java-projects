package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public void PlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player game) {
        return playerRepository.save(game);
    }

    public Iterable<Player> findAllPlayer() {
        return playerRepository.findAll();
    }

    public Optional<Player> findPlayerById(Integer id) {
        return playerRepository.findById(id);
    }
}

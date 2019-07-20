package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.models.Squad;
import com.javaschoolproject.demo.repository.PlayerRepository;
import com.javaschoolproject.demo.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SquadService {
    private SquadRepository squadRepository;

    @Autowired
    public void SquadRepository(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    public Squad createSquad(Squad squad){
        return squadRepository.save(squad);
    }
    public Iterable<Squad> findAllSquad() {
        return squadRepository.findAll();
    }

    public Optional<Squad> findSquadById(Integer id) {
        return squadRepository.findById(id);
    }
    public void deleteSquad(Integer id){
        squadRepository.deleteById(id);
    }
    public void updateSquad(Squad squad){
        squadRepository.save(squad);
    }
    public Squad addPlayer(Squad squad, Player player){
        squad.getPlayers().add(player);
        return squadRepository.save(squad);
    }
}

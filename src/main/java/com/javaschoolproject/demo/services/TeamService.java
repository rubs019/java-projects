package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.models.Team;
import com.javaschoolproject.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(String name){
        Team team = new Team();
        team.setName(name);
        return teamRepository.save(team);
    }
    public Iterable<Team> findAllTeam() {
        return teamRepository.findAll();
    }

    public Optional<Team> findTeamById(Integer id) {
        return teamRepository.findById(id);
    }
    public void deleteTeam(Integer id){
        teamRepository.deleteById(id);
    }
    public void updateTeam(Team team){
        teamRepository.save(team);
    }
    public void addPlayer(Team team, Player player){
        //team.getSquads().add(player);
        //teamRepository.save(team);
    }
}

package com.javaschoolproject.demo.helpers;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.models.Squad;
import com.javaschoolproject.demo.models.Team;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TeamBalancer {
    // On perd des joueurs à retravailler
    public static Team balance(Team team) {
        Set<Squad> squads = team.getSquads();
        Stack<Player> players = new Stack<>();
        squads.forEach((squad -> {
            squad.getPlayers().iterator().forEachRemaining(players::add);
            squad.cleanPlayers();
        }));
        int nombreSquad = squads.size();
        int max = players.size() / nombreSquad;
        squads.forEach(squad -> {
            Set<Player> tempPlayer = new HashSet<>();
            for (int j = 0; j < max; j++) {
                tempPlayer.add(players.pop());
            }
            squad.setPlayers(tempPlayer);
        });

        // team.cleanSquad();
        team.setSquads(squads);
        return team;
    };
}

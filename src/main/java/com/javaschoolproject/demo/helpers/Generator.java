package com.javaschoolproject.demo.helpers;

import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.models.Squad;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator {
    public static Set<Player> playersGenerator(Integer playerMax) {
        Set<Player> players = new HashSet<>();

        while(players.size() < playerMax) {
            Player p = new Player("test", "test", "test", "test@test.com");
            p.setId(new Random().nextInt(100));
            players.add(p);
        }
        return players;
    }

    public static Set<Squad> squadGenerator(Integer squadMax) {
        Set<Squad> squads = new HashSet<>();
        while(squads.size() < squadMax) {
            Integer playerMax = new Random().nextInt(10);
            squads.add(new Squad("Ange de la mort", playersGenerator(playerMax)));
        }
        return squads;
    }
}

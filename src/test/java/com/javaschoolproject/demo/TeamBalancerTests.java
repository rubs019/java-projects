package com.javaschoolproject.demo;

import com.javaschoolproject.demo.helpers.Generator;
import com.javaschoolproject.demo.helpers.TeamBalancer;
import com.javaschoolproject.demo.models.Player;
import com.javaschoolproject.demo.models.Squad;
import com.javaschoolproject.demo.models.Team;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TeamBalancerTests {
    @Test
    public void I_try_to_balance_a_team() {
        Team team = new Team();
        Set<Player> players1 = Generator.playersGenerator(1);
        Set<Player> players2 = Generator.playersGenerator(9);
        Squad squad1 = new Squad();
        Squad squad2 = new Squad();

        squad1.setPlayers(players1);
        squad2.setPlayers(players2);
        Set<Squad> squads = new HashSet<>();
        squads.add(squad1);
        squads.add(squad2);
        team.setSquads(squads);

        Team balancedTeam = TeamBalancer.balance(team);

        balancedTeam.getSquads().forEach(squad -> {
            Assert.assertEquals(5, squad.getPlayers().size());
        });
    }
}

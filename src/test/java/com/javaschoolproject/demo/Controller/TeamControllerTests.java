package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.helpers.Generator;
import com.javaschoolproject.demo.helpers.TeamBalancer;
import com.javaschoolproject.demo.models.*;
import com.javaschoolproject.demo.repository.TeamRepository;
import com.javaschoolproject.demo.services.TeamService;
import org.assertj.core.util.diff.Chunk;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TeamControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private TeamService teamService;

        @MockBean
        private TeamRepository teamRepository;

        @Test
        public void TeamBalancer() {
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

        /*@Test
        public void success_get() throws Exception {
            Mockito.when(gameService.findAllGame()).thenReturn(new ArrayList<>());

            mockMvc.perform(MockMvcRequestBuilders
                    .get("/partie"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("[]"));
        }

        @Test
        public void success_on_partie_creation() throws Exception {
            Game game = new Game();
            game.setName("test");
            game.setStock(2);
            game.setDate(new Date(716940000));
            game.setPlace(32);


            Mockito.when(gameService.createGame(game)).thenReturn(game);

            mockMvc.perform(
                    MockMvcRequestBuilders.post("/game")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(game)))
                    .andExpect(status().isCreated())
                    .andExpect(header().string("location", containsString("http://localhost/partie/")));


            verify(gameService, times(1)).createGame(game);
            verifyNoMoreInteractions(gameService);
        }
        */
}


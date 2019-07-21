/*
package com.javaschoolproject.demo.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaschoolproject.demo.models.Game;
import com.javaschoolproject.demo.repository.GameRepository;
import com.javaschoolproject.demo.services.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GameControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @MockBean
    private GameRepository gameRepository;

    @Test
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

    @Test
    public void failed_when_name_is_too_short() throws Exception {

        Game game = new Game();
        game.setName("2");
        Mockito.when(gameService.createGame(game)).thenReturn(game);
        Mockito.when(gameRepository.save(game)).thenReturn(game);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/game")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(game)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

        verify(gameService, times(1)).createGame(game);
        verify(gameRepository, times(1)).findAll();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
*/

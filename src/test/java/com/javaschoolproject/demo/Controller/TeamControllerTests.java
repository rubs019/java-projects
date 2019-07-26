package com.javaschoolproject.demo.Controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javaschoolproject.demo.models.Team;
import com.javaschoolproject.demo.services.TeamService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TeamControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @Mock
        private TeamService teamService;

        @InjectMocks // auto inject Controller
        TeamController teamController;

        @Before
        public void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
        }

        /*@BeforeEach
        void setMockOutput() {
            Team defaultTeam = new Team();
            test.add(defaultTeam);
            when(teamController.getAllTeams()).thenReturn(test);
        }*/

        @Test
        public void success_get() throws Exception {

            mockMvc.perform(MockMvcRequestBuilders
                    .get("/teams"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("[]"));
        }

        @Test
        public void success_post() throws Exception {

                ObjectMapper objectMapper = new ObjectMapper();
                Team team = new Team();
                team.setName("Aigle royale");
                JSONObject t = new JSONObject();
                t.put("name","Aigle Royale");
                // objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
                //objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                String json = objectMapper.writeValueAsString(t);

                mockMvc.perform(MockMvcRequestBuilders
                        .post("/teams")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(json))
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().json("[]"));
        }

        public static String asJsonString(final Object obj) {
                try {
                        final ObjectMapper mapper = new ObjectMapper();
                        final String jsonContent = mapper.writeValueAsString(obj);
                        System.out.println(jsonContent);
                        return jsonContent;
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }

        /*@Test
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


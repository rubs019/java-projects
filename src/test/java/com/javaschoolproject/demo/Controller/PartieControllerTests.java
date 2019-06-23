package com.javaschoolproject.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaschoolproject.demo.models.Partie;
import com.javaschoolproject.demo.repository.PartieRepository;
import com.javaschoolproject.demo.services.PartieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
public class PartieControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PartieService partieService;

    @MockBean
    private PartieRepository partieRepository;

    @Test
    public void success_get() throws Exception {
        Mockito.when(partieService.findAllPartie()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/partie"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void success_on_partie_creation() throws Exception {
        Partie partie = new Partie();
        partie.setNom("test");
        partie.setStock(2);
        partie.setDate(new Date(716940000));
        partie.setPlace(32);


        Mockito.when(partieService.createPartie(partie)).thenReturn(partie);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/partie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(partie)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost/partie/")));


        verify(partieService, times(1)).createPartie(partie);
        verifyNoMoreInteractions(partieService);
    }

    @Test
    public void failed_when_name_is_too_short() throws Exception {

        Partie partie = new Partie();
        partie.setNom("2");
        Mockito.when(partieService.createPartie(partie)).thenReturn(partie);
        Mockito.when(partieRepository.save(partie)).thenReturn(partie);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/partie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(partie)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

        verify(partieService, times(1)).createPartie(partie);
        verify(partieRepository, times(1)).findAll();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


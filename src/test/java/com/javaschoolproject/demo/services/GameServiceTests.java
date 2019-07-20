package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.repository.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameServiceTests {
    private static final int TEST_STOCK_QUANTITY = 15;
    private static final String TEST_NAME = "Toto";
    private static final int TEST_PLACE_AVAILABLE = 15;

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService testingObject;

    @Test
    public void testCreatePartie() {
        /*Game partie = new Game();
        partie.setStock(TEST_STOCK_QUANTITY);
        partie.setNom(TEST_NAME);
        partie.setPlace(TEST_STOCK_QUANTITY);
        Mockito.when(partieRepository.save(partie)).thenReturn(partie);

        Game partieCreated = testingObject.createPartie(partie);
        Assert.assertEquals(TEST_STOCK_QUANTITY, partieCreated.getStock());
        Assert.assertEquals(TEST_NAME, partieCreated.getNom());
        Assert.assertEquals(TEST_PLACE_AVAILABLE, partieCreated.getPlace());*/
    }
}

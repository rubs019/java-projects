package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Partie;
import com.javaschoolproject.demo.repository.PartieRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PartieServiceTests {
    private static final int TEST_STOCK_QUANTITY = 15;
    private static final String TEST_NAME = "Toto";
    private static final int TEST_PLACE_AVAILABLE = 15;

    @Mock
    private PartieRepository partieRepository;

    @InjectMocks
    private PartieService testingObject;

    @Test
    public void testCreatePartie() {
        /*Partie partie = new Partie();
        partie.setStock(TEST_STOCK_QUANTITY);
        partie.setNom(TEST_NAME);
        partie.setPlace(TEST_STOCK_QUANTITY);
        Mockito.when(partieRepository.save(partie)).thenReturn(partie);

        Partie partieCreated = testingObject.createPartie(partie);
        Assert.assertEquals(TEST_STOCK_QUANTITY, partieCreated.getStock());
        Assert.assertEquals(TEST_NAME, partieCreated.getNom());
        Assert.assertEquals(TEST_PLACE_AVAILABLE, partieCreated.getPlace());*/
    }
}

package com.javaschoolproject.demo;

import com.javaschoolproject.demo.Administrator.Administrator;
import com.javaschoolproject.demo.Administrator.AdministratorController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AdministratorMockTests {

    @Mock
    private AdministratorController administratorController;

    @InjectMocks // auto inject Administrator
    private List<Administrator> test = new ArrayList<>();

    @BeforeEach
    void setMockOutput() {
        Administrator defaultUser = new Administrator();
        defaultUser.setLogin("Ruben");
        defaultUser.setPassword("root");
        test.add(defaultUser);
        when(administratorController.getAllAdministrator()).thenReturn(test);
    }

    @Test
    public void testGet() {
        assertEquals(test, administratorController.getAllAdministrator());
    }

}


package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.DTO.Meteo.MeteoDto;
import com.javaschoolproject.demo.Exceptions.ApiNotFoundException;
import com.javaschoolproject.demo.services.MeteoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/meteo")
public class MeteoController {

    private static final Logger logger = LoggerFactory.getLogger(MeteoController.class);

    @Autowired
    private MeteoService meteoService;

    @GetMapping()
    private MeteoDto getMeteoWithCityId(@RequestParam("id") Optional<String> id) {
        try {
            MeteoDto meteoDto = meteoService.getMeteoWithCityId(id);
            logger.info(meteoDto.toString());
            return meteoDto;
        } catch (ApiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}

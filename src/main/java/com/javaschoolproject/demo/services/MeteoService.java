package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.Controller.MeteoController;
import com.javaschoolproject.demo.DTO.Meteo.MeteoDto;
import com.javaschoolproject.demo.Exceptions.ApiNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MeteoService {

    private static final Logger logger = LoggerFactory.getLogger(MeteoService.class);

    @Value("${api_key_optional}")
    private String API_KEY;

    public MeteoDto getMeteoWithCityId(Optional<String> id) throws ApiNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String idParisWeather = "2988507";

        logger.info("API_KEY : ".concat(API_KEY));
        if(API_KEY == null)
            throw new ApiNotFoundException();

        String finalId = id.orElse(idParisWeather);

        return restTemplate.getForObject(
            "https://api.openweathermap.org/data/2.5/weather?id="
                    .concat(finalId)
                    .concat("&appid=")
                    .concat(API_KEY),
            MeteoDto.class);
    }

}

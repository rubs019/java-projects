package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.DTO.Meteo.MeteoDto;
import com.javaschoolproject.demo.Exceptions.ApiNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeteoService {

    @Value("${api_key_optional}")
    private String API_KEY;

    public MeteoDto getMeteoWithCityId(String id) throws ApiNotFoundException {

        RestTemplate restTemplate = new RestTemplate();

        if(API_KEY == null)
            throw new ApiNotFoundException();

        MeteoDto meteoDto = restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?id="
                        .concat(id)
                        .concat("&appid=")
                        .concat(API_KEY),
                MeteoDto.class);

        return meteoDto;
    }

}

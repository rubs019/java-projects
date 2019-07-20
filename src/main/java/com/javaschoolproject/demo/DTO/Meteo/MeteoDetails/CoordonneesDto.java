package com.javaschoolproject.demo.DTO.Meteo.MeteoDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoordonneesDto {

    @JsonProperty("lon")
    private Float longitude;
    @JsonProperty("lat")
    private Float latitude;

    public CoordonneesDto() {
    }

    public CoordonneesDto(Float longitude, Float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "CoordonneesDto{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}

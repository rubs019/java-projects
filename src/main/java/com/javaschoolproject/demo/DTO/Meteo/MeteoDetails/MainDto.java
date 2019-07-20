package com.javaschoolproject.demo.DTO.Meteo.MeteoDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainDto {
    private Float temp;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty("temp_min")
    private Float teamperatureMin;
    @JsonProperty("temp_max")
    private Float teamperatureMax;

    public MainDto() {
    }

    public MainDto(Float temp, Integer pressure, Integer humidity, Float teamperatureMin, Float teamperatureMax) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.teamperatureMin = teamperatureMin;
        this.teamperatureMax = teamperatureMax;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Float getTeamperatureMin() {
        return teamperatureMin;
    }

    public void setTeamperatureMin(Float teamperatureMin) {
        this.teamperatureMin = teamperatureMin;
    }

    public Float getTeamperatureMax() {
        return teamperatureMax;
    }

    public void setTeamperatureMax(Float teamperatureMax) {
        this.teamperatureMax = teamperatureMax;
    }

    @Override
    public String toString() {
        return "MainDto{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", teamperatureMin=" + teamperatureMin +
                ", teamperatureMax=" + teamperatureMax +
                '}';
    }
}

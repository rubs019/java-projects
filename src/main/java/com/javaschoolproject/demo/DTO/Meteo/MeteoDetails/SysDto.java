package com.javaschoolproject.demo.DTO.Meteo.MeteoDetails;

import java.math.BigInteger;

public class SysDto {

    private Integer type;
    private Integer id;
    private Float message;
    private String country;
    private BigInteger sunrise;
    private BigInteger sunset;

    public SysDto() {
    }

    public SysDto(Integer type, Integer id, Float message, String country, BigInteger sunrise, BigInteger sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigInteger getSunrise() {
        return sunrise;
    }

    public void setSunrise(BigInteger sunrise) {
        this.sunrise = sunrise;
    }

    public BigInteger getSunset() {
        return sunset;
    }

    public void setSunset(BigInteger sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "SysDto{" +
                "type=" + type +
                ", id=" + id +
                ", message=" + message +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}

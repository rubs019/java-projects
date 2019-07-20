package com.javaschoolproject.demo.DTO.Meteo.MeteoDetails;

public class WindDto {
    private Float speed;
    private Integer deg;

    public WindDto() {
    }

    public WindDto(Float speed, Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "WindDto{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}

package com.javaschoolproject.demo.DTO.Meteo.MeteoDetails;

public class CloudsDto {
    private Integer all;

    public CloudsDto() {
    }

    public CloudsDto(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "CloudsDto{" +
                "all=" + all +
                '}';
    }
}

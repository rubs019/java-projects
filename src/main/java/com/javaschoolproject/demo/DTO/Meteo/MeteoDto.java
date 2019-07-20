package com.javaschoolproject.demo.DTO.Meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaschoolproject.demo.DTO.Meteo.MeteoDetails.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoDto {
    @JsonProperty("coord")
    private CoordonneesDto coordonneesDto;
    @JsonProperty("weather")
    private List<WeatherDto> weatherDto;
    private String base;
    @JsonProperty("main")
    private MainDto mainDto;
    private Integer visibility;
    @JsonProperty("wind")
    private WindDto windDto;
    @JsonProperty("clouds")
    private CloudsDto cloudsDto;
    private Integer dt;
    private SysDto sysDto;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;

    public MeteoDto() {
    }

    public MeteoDto(CoordonneesDto coordonneesDto, List<WeatherDto> weatherDto, String base, MainDto mainDto, Integer visibility, WindDto windDto, CloudsDto cloudsDto, Integer dt, SysDto sysDto, Integer timezone, Integer id, String name, Integer cod) {
        this.coordonneesDto = coordonneesDto;
        this.weatherDto = weatherDto;
        this.base = base;
        this.mainDto = mainDto;
        this.visibility = visibility;
        this.windDto = windDto;
        this.cloudsDto = cloudsDto;
        this.dt = dt;
        this.sysDto = sysDto;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public CoordonneesDto getCoordonneesDto() {
        return coordonneesDto;
    }

    public void setCoordonneesDto(CoordonneesDto coordonneesDto) {
        this.coordonneesDto = coordonneesDto;
    }

    public List<WeatherDto> getWeatherDto() {
        return weatherDto;
    }

    public void setWeatherDto(List<WeatherDto> weatherDto) {
        this.weatherDto = weatherDto;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainDto getMainDto() {
        return mainDto;
    }

    public void setMainDto(MainDto mainDto) {
        this.mainDto = mainDto;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public WindDto getWindDto() {
        return windDto;
    }

    public void setWindDto(WindDto windDto) {
        this.windDto = windDto;
    }

    public CloudsDto getCloudsDto() {
        return cloudsDto;
    }

    public void setCloudsDto(CloudsDto cloudsDto) {
        this.cloudsDto = cloudsDto;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public SysDto getSysDto() {
        return sysDto;
    }

    public void setSysDto(SysDto sysDto) {
        this.sysDto = sysDto;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "MeteoDto{" +
                "coordonneesDto=" + coordonneesDto +
                ", weatherDto=" + weatherDto +
                ", base='" + base + '\'' +
                ", mainDto=" + mainDto +
                ", visibility=" + visibility +
                ", windDto=" + windDto +
                ", cloudsDto=" + cloudsDto +
                ", dt=" + dt +
                ", sysDto=" + sysDto +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
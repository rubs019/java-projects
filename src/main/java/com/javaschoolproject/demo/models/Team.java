package com.javaschoolproject.demo.models;

import net.bytebuddy.implementation.bytecode.Throw;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Team {
    static final Integer NB_MAX_SQUAD = 8;
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Squad> squads;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Day> days;

    public Team() {
    }

    public Team(@NotNull String name) {
        this.name = name;
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

    public Set<Squad> getSquads() {
        return squads;
    }

    public void setSquads(Set<Squad> squads) {
        if (squads.size() > NB_MAX_SQUAD) {
            return;
        }
        this.squads = squads;
    }

    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }

    public void cleanSquad() {
        squads.clear();
    }
}

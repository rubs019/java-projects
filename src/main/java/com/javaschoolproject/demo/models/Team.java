package com.javaschoolproject.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Squad> squads;

    public Team() {
    }

    public Team(@NotNull String name, Set<Squad> squads) {
        this.name = name;
        this.squads = squads;
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
        this.squads = squads;
    }
}

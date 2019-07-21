package com.javaschoolproject.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Entity
public class Squad implements Serializable {
    @Id
    private UUID id;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "squad", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Player> players;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id")
    @JsonIgnore
    private Team team;

    public Squad() {
        this.setId(UUID.randomUUID());
    }

    public Squad(@NotNull String name, Set<Player> players) {
        this.setId(UUID.randomUUID());
        this.name = name;
        this.players = players;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void cleanPlayers() {
        players.clear();
    }
}

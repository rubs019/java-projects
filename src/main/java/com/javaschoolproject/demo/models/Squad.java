package com.javaschoolproject.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Squad implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "squad", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Player> players;

    public Squad() {
    }

    public Squad(@NotNull String name, Set<Player> players) {
        this.name = name;
        this.players = players;
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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}

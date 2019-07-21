package com.javaschoolproject.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    private String description;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Day> day;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Goal> goal;

    public Game(){ }

    public Game( String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Goal> getGoal() {
        return goal;
    }

    public void setGoal(Set<Goal> goal) {
        this.goal = goal;
    }

    public Set<Day> getDay() {
        return day;
    }

    public void setDay(Set<Day> day) {
        this.day = day;
    }
}

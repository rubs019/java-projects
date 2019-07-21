package com.javaschoolproject.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Goal implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id")
    @JsonIgnore
    private Game game;

    public Goal(){

    }

    public Goal(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package com.javaschoolproject.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Goal implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)

    private Long id;
    private String nom;
    private String type;

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

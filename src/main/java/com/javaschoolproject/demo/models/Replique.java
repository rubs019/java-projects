package com.javaschoolproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Replique implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)

    private Long id;
    private String nom;

    public Replique(){

    }

    public Replique(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

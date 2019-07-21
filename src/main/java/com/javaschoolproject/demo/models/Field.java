package com.javaschoolproject.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Field implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)

    private Long id;
    private String nom;
    private String localisation;

    public Field(){

    }

    public Field(String nom, String localisation) {
        this.nom = nom;
        this.localisation = localisation;
    }

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Day> days;

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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }
}

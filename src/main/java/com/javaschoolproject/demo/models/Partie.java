package com.javaschoolproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Partie {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;
    private Date date;
    @Size(min = 3, max = 20)
    private String nom;
    private int place;
    private int stock;

    public Partie(){

    }

    public Partie(Date date, String nom, int place, int stock) {
        this.date = date;
        this.nom = nom;
        this.place = place;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

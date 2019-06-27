package com.javaschoolproject.demo.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)

    private Long id;
    private int id_replique;
    private int quantite

    public Stock(){

    }

    public Stock(int id_replique, int quantite) {
        this.id_replique = id_replique;
        this.quantite = quantite;
    }

    public int getId_replique() {
        return id_replique;
    }

    public void setId_replique(int id_replique) {
        this.id_replique = id_replique;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}

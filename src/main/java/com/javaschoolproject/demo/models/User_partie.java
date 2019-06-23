package com.javaschoolproject.demo.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User_partie implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)

    private Long id;
    private int id_user;
    private int id_partie;

    public User_partie(){

    }

    public User_partie(int id_user, int id_partie) {
        this.id_user = id_user;
        this.id_partie = id_partie;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_partie() {
        return id_partie;
    }

    public void setId_partie(int id_partie) {
        this.id_partie = id_partie;
    }
}

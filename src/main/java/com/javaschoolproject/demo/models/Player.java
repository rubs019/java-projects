package com.javaschoolproject.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="squad_id")
    @JsonIgnore
    private Squad squad;

    public Player(String username, String lastName, String firstName,String email) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Player(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }
}

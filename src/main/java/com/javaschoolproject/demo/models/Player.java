package com.javaschoolproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}

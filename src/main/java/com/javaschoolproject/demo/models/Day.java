package com.javaschoolproject.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Day implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="field_id")
    private Field field;

    public Day() {
    }

    public Day(String name, String description, Field field) {
        this.name = name;
        this.description = description;
        this.field = field;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}

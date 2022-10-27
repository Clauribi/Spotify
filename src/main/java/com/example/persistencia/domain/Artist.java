package com.example.persistencia.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name="artists")
public class Artist {
    @Id
    private String id;
    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is empty")
    private String name;

    public Artist() {
    }

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

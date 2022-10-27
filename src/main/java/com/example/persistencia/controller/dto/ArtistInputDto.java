package com.example.persistencia.controller.dto;

import com.example.persistencia.domain.Artist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArtistInputDto {
    private String id;
    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is empty")
    private String name;


    public ArtistInputDto() {
    }

    public ArtistInputDto(String id, String name) {
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
    public Artist toDomain(){
        return new Artist(this.id, this.name);
    }
}

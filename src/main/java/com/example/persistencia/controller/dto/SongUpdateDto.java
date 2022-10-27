package com.example.persistencia.controller.dto;

import com.example.persistencia.domain.Song;

import javax.validation.constraints.NotNull;

public class SongUpdateDto {
    @NotNull(message = "Favourite is null")
    private boolean favourite;

    public SongUpdateDto() {
    }

    public SongUpdateDto(boolean favourite) {
        this.favourite = favourite;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public Song toDomain(String songId, String title, String artistId) {
        return new Song(songId, title, this.favourite, artistId);
    }
}


package com.example.persistencia.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "songs")
public class Song {
    @Id
    private String songId;
    @NotNull(message = "Title is null")
    @NotBlank(message = "Title is empty")
    private String title;
    @NotNull(message = "Favourite is null")
    private boolean favourite;
    @NotNull(message = "Artist id is null")
    @NotBlank(message = "Artist id is empty")
    private String artistId;

    public Song() {
    }

    public Song(String songId, String title, boolean favourite, String artistId) {
        this.songId = songId;
        this.title = title;
        this.favourite = favourite;
        this.artistId = artistId;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
}

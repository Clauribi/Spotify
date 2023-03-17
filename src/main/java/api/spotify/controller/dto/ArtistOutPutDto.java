package api.spotify.controller.dto;

import api.spotify.domain.Song;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


public class ArtistOutPutDto {
    @NotNull(message = "Id is null")
    @NotBlank(message = "Id is empty")
    private String id;
    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is empty")
    private String name;
    private List<Song> songs;

    public ArtistOutPutDto() {
    }

    public ArtistOutPutDto(String id, String name, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}

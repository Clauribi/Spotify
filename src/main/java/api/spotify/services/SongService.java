package api.spotify.services;

import api.spotify.domain.Song;
import api.spotify.domain.exceptions.ArtistDoesNotExist;
import api.spotify.domain.exceptions.SongAlreadyExists;
import api.spotify.domain.exceptions.SongDoesNotExist;
import api.spotify.repositories.ArtistRepository;
import api.spotify.repositories.SongRepository;
import api.spotify.controller.dto.SongInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;

    public void addSong(SongInputDto songInputDto) throws ArtistDoesNotExist, SongAlreadyExists {
        if(!artistRepository.existsById(songInputDto.getArtistId())) throw new ArtistDoesNotExist("Artist doesn´t exist.");
        Song s = songInputDto.toDomain();
        songRepository.save(s);
        if(songRepository.existsById(songInputDto.getSongId())) throw new SongAlreadyExists("Song already exists.");

    }
    public void changeFavouriteSong(String songId) throws SongDoesNotExist {
        if (!songRepository.existsById(songId)) throw new SongDoesNotExist("Song doesn´t exist.");
        Song song = songRepository.getOne(songId);
        if(song.isFavourite()){
            song.setFavourite(false);
        }else{
            song.setFavourite(true);
        }
        songRepository.save(song);
    }
}

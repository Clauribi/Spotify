package com.example.persistencia.services;

import com.example.persistencia.controller.dto.SongInputDto;
import com.example.persistencia.controller.dto.SongUpdateDto;
import com.example.persistencia.domain.Song;
import com.example.persistencia.domain.exceptions.ArtistDoesNotExist;
import com.example.persistencia.domain.exceptions.SongAlreadyExists;
import com.example.persistencia.domain.exceptions.SongDoesNotExist;
import com.example.persistencia.repositories.ArtistRepository;
import com.example.persistencia.repositories.SongRepository;
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
    public void changeFavouriteSong(String songId,SongUpdateDto songUpdateDto) throws SongDoesNotExist {
        if (!songRepository.existsById(songId)) throw new SongDoesNotExist("Song doesn´t exist.");
        Song song = songRepository.getOne(songId);
        Song sUpdate = songUpdateDto.toDomain(songId, song.getTitle(), song.getArtistId());
        songRepository.save(sUpdate);
    }
}

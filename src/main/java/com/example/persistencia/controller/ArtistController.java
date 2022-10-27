package com.example.persistencia.controller;

import com.example.persistencia.controller.dto.ArtistInputDto;
import com.example.persistencia.controller.dto.ArtistOutPutDto;
import com.example.persistencia.domain.Artist;
import com.example.persistencia.domain.Song;
import com.example.persistencia.domain.exceptions.ArtistAlreadyExists;
import com.example.persistencia.domain.exceptions.ArtistsDoNotExist;
import com.example.persistencia.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/artists")
    public ResponseEntity<ArtistInputDto> createArtist(@Valid @RequestBody ArtistInputDto artistInputDto) {
        try {
            artistService.addArtist(artistInputDto);
        } catch (ArtistAlreadyExists e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        } catch (Exception e1) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/artists/songs")
    public ResponseEntity<List<ArtistOutPutDto>> allArtistsAndSongs() {
        try {
            List<ArtistOutPutDto> listAllArtistAndSongs = artistService.getAllArtistsAndSongs();
            return ResponseEntity.ok(listAllArtistAndSongs);
        } catch (ArtistsDoNotExist e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e1) {
            return ResponseEntity.notFound().build();
        }
    }
}

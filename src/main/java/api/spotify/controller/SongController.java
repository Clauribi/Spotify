package api.spotify.controller;

import api.spotify.controller.dto.SongInputDto;
import api.spotify.domain.exceptions.ArtistDoesNotExist;
import api.spotify.domain.exceptions.SongAlreadyExists;
import api.spotify.domain.exceptions.SongDoesNotExist;
import api.spotify.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/songs/artist")
    public ResponseEntity<SongInputDto> createSong(@Valid @RequestBody SongInputDto songInputDto){
        try{
            songService.addSong(songInputDto);
        }catch (ArtistDoesNotExist e){
            e.printStackTrace();
            ResponseEntity.badRequest().build();
        }catch (SongAlreadyExists e1){
            e1.printStackTrace();
            ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }catch (Exception e2){
            ResponseEntity.notFound();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/song/{songId}/favourite")
    public  ResponseEntity<SongInputDto> markFavouriteSong(@PathVariable String songId){
        try{
            songService.changeFavouriteSong(songId);
        } catch (SongDoesNotExist e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e1){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}

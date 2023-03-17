package api.spotify.controller;

import api.spotify.controller.dto.ArtistInputDto;
import api.spotify.controller.dto.ArtistOutPutDto;
import api.spotify.domain.exceptions.ArtistAlreadyExists;
import api.spotify.domain.exceptions.ArtistsDoNotExist;
import api.spotify.services.ArtistService;
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

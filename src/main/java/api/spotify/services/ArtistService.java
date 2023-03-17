package api.spotify.services;

import api.spotify.controller.dto.ArtistInputDto;
import api.spotify.controller.dto.ArtistOutPutDto;
import api.spotify.domain.Artist;
import api.spotify.domain.Song;
import api.spotify.domain.exceptions.ArtistAlreadyExists;
import api.spotify.domain.exceptions.ArtistsDoNotExist;
import api.spotify.repositories.ArtistRepository;
import api.spotify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;

    public void addArtist(ArtistInputDto artistInputDto) throws ArtistAlreadyExists {
        if (artistRepository.existsById(artistInputDto.getId()))
            throw new ArtistAlreadyExists("Artist already exists.");
        Artist a = artistInputDto.toDomain();
        artistRepository.save(a);
    }

    public List<ArtistOutPutDto> getAllArtistsAndSongs() throws ArtistsDoNotExist {
        List<ArtistOutPutDto> allArtistsAndSongs = new ArrayList<>();
        List<Artist> allArtist = artistRepository.findAll();
        if(allArtist.isEmpty()) throw new ArtistsDoNotExist("Artists don´t exist.");
        for (Artist artist : allArtist) {
            List<Song> allSongs = songRepository.findAllByArtistId(artist.getId());
            allArtistsAndSongs.add(new ArtistOutPutDto(artist.getId(), artist.getName(), allSongs));
        }
        return allArtistsAndSongs;
    }
}
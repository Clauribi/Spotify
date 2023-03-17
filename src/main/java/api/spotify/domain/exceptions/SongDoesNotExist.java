package api.spotify.domain.exceptions;

public class SongDoesNotExist extends Exception {
    public SongDoesNotExist(String message) {
        super(message);
    }
}

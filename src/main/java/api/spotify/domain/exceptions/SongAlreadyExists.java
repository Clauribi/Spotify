package api.spotify.domain.exceptions;

public class SongAlreadyExists extends Exception {
    public SongAlreadyExists(String message) {
        super(message);
    }
}

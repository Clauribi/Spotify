package api.spotify.domain.exceptions;

public class ArtistsDoNotExist extends Exception {
    public ArtistsDoNotExist(String message) {
        super(message);
    }
}

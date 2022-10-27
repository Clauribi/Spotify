package com.example.persistencia.domain.exceptions;

public class ArtistDoesNotExist extends Exception {
    public ArtistDoesNotExist(String message) {
        super(message);
    }
}

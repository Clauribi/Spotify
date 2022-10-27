package com.example.persistencia.domain.exceptions;

public class ArtistAlreadyExists extends Exception {
    public ArtistAlreadyExists(String message) {
        super(message);
    }
}

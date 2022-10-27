package com.example.persistencia.domain.exceptions;

public class SongDoesNotExist extends Exception {
    public SongDoesNotExist(String message) {
        super(message);
    }
}

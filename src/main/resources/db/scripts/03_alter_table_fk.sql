ALTER TABLE songs ADD CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artists (id);

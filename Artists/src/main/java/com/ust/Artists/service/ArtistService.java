package com.ust.Artists.service;

import com.ust.Artists.model.Artist;
import com.ust.Artists.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository repository;

    public Artist createArtistProfile(String artistId, Artist artist) {
        artist.setArtistId(artistId);
        return repository.save(artist);
    }

    public Optional<Artist> getArtistProfile(String artistId) {
        return repository.findById(artistId);
    }

    public Artist updateArtistProfile(String artistId, Artist updatedArtist) {
        updatedArtist.setArtistId(artistId);
        return repository.save(updatedArtist);
    }

    public void deleteArtistProfile(String artistId) {
        repository.deleteById(artistId);
    }

    public List<Artist> getAllArtists() {
        return repository.findAll();
    }
}

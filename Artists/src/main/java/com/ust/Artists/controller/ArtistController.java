package com.ust.Artists.controller;

import com.ust.Artists.client.TalentPostClient;
import com.ust.Artists.dto.TalentPost;
import com.ust.Artists.model.Artist;
import com.ust.Artists.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
@CrossOrigin
public class ArtistController {

    @Autowired
    private ArtistService service;
    private TalentPostClient talentPostClient;

    @PostMapping
    public ResponseEntity<Artist> createArtist(@PathVariable String artistId, @RequestBody Artist artist) {
        return ResponseEntity.ok(service.createArtistProfile(artistId, artist));
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(service.getAllArtists());
    }

    @GetMapping("/{artistId}")
    public ResponseEntity<Artist> getArtist(@PathVariable String artistId) {
        Optional<Artist> artist = service.getArtistProfile(artistId);
        return artist.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{artistId}")
    public ResponseEntity<Artist> updateArtist(@PathVariable String artistId, @RequestBody Artist updatedArtist) {
        return ResponseEntity.ok(service.updateArtistProfile(artistId, updatedArtist));
    }

    @DeleteMapping("/{artistId}")
    public ResponseEntity<Void> deleteArtist(@PathVariable String artistId) {
        service.deleteArtistProfile(artistId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/posts")
    public ResponseEntity<List<TalentPost>> getAllPosts() {
        return talentPostClient.getAllPosts();
    }
}

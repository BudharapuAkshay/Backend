package com.ust.Applications.client;

import com.ust.Applications.dto.Artist;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Artists", url = "http://localhost:5050")
public interface ArtistClient {
    @GetMapping("/api/artists/{artistId}")
    Artist getArtistById(@PathVariable String artistId);
}

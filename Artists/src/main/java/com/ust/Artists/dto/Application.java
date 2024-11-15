package com.ust.Artists.dto;

import lombok.Data;

@Data
public class Application {

    private String applicationId;
    private String postId;
    private String artistId;    // References the Artist's artistId
    private boolean isShortlisted = false;
}

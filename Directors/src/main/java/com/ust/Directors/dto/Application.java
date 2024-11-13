package com.ust.Directors.dto;

import lombok.Data;

@Data
public class Application {
    private String applicationId;
    private String postId;
    private String artistId;
    private boolean isShortlisted;
    private String fileUrl;
}

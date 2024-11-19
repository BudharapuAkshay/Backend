package com.ust.Directors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {
    private String applicationId;
    private String artistId;
    private String artistProfilePicture;
    private String artistName;
    private String artistType;
    private String artistExperience;
    private boolean isShortlisted;
    private String fileUrl;
    private String artistEmail;
    private String artistPrimaryWorkLocation;
}

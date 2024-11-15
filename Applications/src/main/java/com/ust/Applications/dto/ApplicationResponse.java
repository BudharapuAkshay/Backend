package com.ust.Applications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {
    private String applicationId;
    private String artistProfilePicture;
    private String artistName;
    private String artistType;
    private String artistExperience;
    private boolean isShortlisted;
    private String artistEmail;
    private String artistPrimaryWorkLocation;
}

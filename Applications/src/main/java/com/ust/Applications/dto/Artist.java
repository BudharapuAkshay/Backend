package com.ust.Applications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    private String artistId;
    private String artistName;
    private String artistProfilePicture;
    private String artistAbout;
    private String artistPrimaryWorkLocation;
    private String artistHeight;
    private String artistWeight;
    private String artistAge;
    private List<String> artistSpecialSkills;
    private String artistExperience;
    private String artistType;
    private String artistEmail;
    private String artistPhoneNumber;
}

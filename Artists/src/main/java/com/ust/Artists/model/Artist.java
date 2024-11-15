package com.ust.Artists.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "artists")
public class Artist {

    @Id
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

package com.ust.Applications.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "applications")
public class Application {
    @Id
    private String applicationId;
    private String postId;      // References the TalentPost's postId
    private String artistId;    // References the Artist's artistId
    private boolean isShortlisted = false;     // Status of the application

}



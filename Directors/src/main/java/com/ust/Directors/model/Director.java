package com.ust.Directors.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "directors")
public class Director {
    @Id
    private String directorId;
    private String directorName;
    private String directorDesignation;
    private String directorProfilePictureUrl;
    private String directorPhoneNumber;
    private String directorEmailAddress;
    private String directorCompanyName;
    private String directorIndustryExperience;
    private String directorIndustrySpecialization;
}

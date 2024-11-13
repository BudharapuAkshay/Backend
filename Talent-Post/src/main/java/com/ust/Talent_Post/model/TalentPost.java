package com.ust.Talent_Post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "posts")
public class TalentPost {
    @Id
    private String talentPostId;
    private String directorId;
    private String talentPostTalentType;
    private String talentPostRoleType;
    private String talentPostProjectDetails;
    private String talentPostPaymentInfo;
    private String talentPostHours;
    private String talentPostLocation;
    private Date talentPostStartDate;
    private Date talentPostEndDate;
    private String talentPostCompanyInfo;
    private List<String> talentPostPreScreenRequests;
    private String talentPostImageUrl;
    private String talentPostGender;
    private Date talentPostSubmissionDeadline;
}


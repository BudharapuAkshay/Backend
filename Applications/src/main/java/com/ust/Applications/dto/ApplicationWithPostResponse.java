package com.ust.Applications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationWithPostResponse{
    private String applicationId;
    private String artistId;
    private boolean isShortlisted;
    private String fileUrl;
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
    private String talentPostGender;
    private Date talentPostSubmissionDeadline;
    private String talentPostImageUrl;
}

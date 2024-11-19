package com.ust.Artists.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TalentPost {
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


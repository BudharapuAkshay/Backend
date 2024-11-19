package com.ust.Applications.service;

import com.ust.Applications.client.ArtistClient;
import com.ust.Applications.client.TalentPostClient;
import com.ust.Applications.dto.ApplicationResponse;
import com.ust.Applications.dto.ApplicationWithPostResponse;
import com.ust.Applications.dto.Artist;
import com.ust.Applications.dto.TalentPost;
import com.ust.Applications.model.Application;
import com.ust.Applications.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    private final JavaMailSender mailSender;
    private final TalentPostClient talentPostClient;
    private final ArtistClient artistClient;

    @Autowired
    public ApplicationService( JavaMailSender mailSender,
                              TalentPostClient talentPostClient, ArtistClient artistClient) {
        this.mailSender = mailSender;
        this.talentPostClient = talentPostClient;
        this.artistClient = artistClient;
    }

    // Create or apply to a new post
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    // Get all applicants for a specific post
    public List<ApplicationResponse> getApplicationsByPostId(String postId) {
        // Fetch all applications by postId
        List<Application> applications = applicationRepository.findByPostId(postId);

        // Map the applications to the custom DTO
        return applications.stream()
                .map(application -> {
                    Artist artist = artistClient.getArtistById(application.getArtistId());  // Use the Feign client to fetch artist details
                    return new ApplicationResponse(
                            application.getApplicationId(),
                            artist.getArtistId(),
                            artist.getArtistProfilePicture(),
                            artist.getArtistName(),
                            artist.getArtistType(),

                            artist.getArtistExperience(),

                            application.isShortlisted(),
                            application.getFileUrl(),

                            artist.getArtistEmail(),
                            artist.getArtistPrimaryWorkLocation()  // Assuming artistRole is about the artist

                    );
                })
                .collect(Collectors.toList());
    }

    // Get shortlisted applicants for a specific post
    public List<ApplicationResponse> getShortlistedApplicationsByPostId(String postId) {
        List<Application> applications = applicationRepository.findByPostIdAndIsShortlistedTrue(postId);

        // Map the applications to the custom DTO
        return applications.stream()
                .map(application -> {
                    Artist artist = artistClient.getArtistById(application.getArtistId());  // Use the Feign client to fetch artist details
                    return new ApplicationResponse(
                            application.getApplicationId(),
                            artist.getArtistId(),
                            artist.getArtistProfilePicture(),
                            artist.getArtistName(),
                            artist.getArtistType(),

                            artist.getArtistExperience(),

                            application.isShortlisted(),
                            application.getFileUrl(),

                            artist.getArtistEmail(),
                            artist.getArtistPrimaryWorkLocation()  // Assuming artistRole is about the artist

                    );
                })
                .collect(Collectors.toList());
    }

    // Update an application to be shortlisted
    public void updateShortlistStatus(String applicationId) {
        Optional<Application> applicationOpt = applicationRepository.findById(applicationId);
        if (applicationOpt.isPresent()) {
            Application application = applicationOpt.get();
            application.setShortlisted(!application.isShortlisted());
            applicationRepository.save(application);
            return;
        }
        return;
    }

    // Delete an application
    public void deleteApplication(String applicationId) {
        applicationRepository.deleteById(applicationId);
    }

    public void emailShortlistedArtists(String postId) {
        List<Application> shortlistedApplications = applicationRepository.findByPostIdAndIsShortlistedTrue(postId);

        if (shortlistedApplications.isEmpty()) {
            throw new RuntimeException("No shortlisted artists found for post: " + postId);
        }

        // Fetching talent post details for email context
        TalentPost post = talentPostClient.getPostById(postId);

        // Send email to each shortlisted artist
        for (Application application : shortlistedApplications) {
            sendEmailToArtist(application.getArtistId(), post);
        }
    }

    private void sendEmailToArtist(String artistId, TalentPost post) {
        // Example: Fetch artist email and details via Feign or REST client from Artist Service
        Artist artist = artistClient.getArtistById(artistId); // Assuming ArtistClient exists
        String recipientEmail = artist.getArtistEmail();

        // Email content
        String subject = "Opportunity for " + post.getTalentPostRoleType() + " Role";
        String message = "Hello " + artist.getArtistName() + ",\n\n"
                + "We are excited to inform you that you have been shortlisted for the role of "
                + post.getTalentPostRoleType() + " in our project. "
                + "Please feel free to reach out for further details.\n\nBest regards,\n" ;

        // Send email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipientEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    public List<ApplicationWithPostResponse> getApplicationsByArtistId(String artistId) {
        List<Application> applications = applicationRepository.findByArtistId(artistId);

        return applications.stream().map(application -> {
            TalentPost talentPost = talentPostClient.getPostById(application.getPostId());  // Fetch TalentPost by postId

            return new ApplicationWithPostResponse(
                    application.getApplicationId(),
                    application.getArtistId(),
                    application.isShortlisted(),
                    application.getFileUrl(),
                    talentPost.getTalentPostId(),
                    talentPost.getDirectorId(),
                    talentPost.getTalentPostTalentType(),
                    talentPost.getTalentPostRoleType(),
                    talentPost.getTalentPostProjectDetails(),
                    talentPost.getTalentPostPaymentInfo(),
                    talentPost.getTalentPostHours(),
                    talentPost.getTalentPostLocation(),
                    talentPost.getTalentPostStartDate(),
                    talentPost.getTalentPostEndDate(),
                    talentPost.getTalentPostCompanyInfo(),
                    talentPost.getTalentPostPreScreenRequests(),
                    talentPost.getTalentPostGender(),
                    talentPost.getTalentPostSubmissionDeadline(),
                    talentPost.getTalentPostImageUrl()
            );
        }).collect(Collectors.toList());
    }
}



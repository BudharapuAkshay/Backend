package com.ust.Applications.repository;


import com.ust.Applications.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, String> {
    List<Application> findByPostId(String postId);
    List<Application> findByPostIdAndIsShortlistedTrue(String postId);
    List<Application> findByArtistId(String artistId);
}



package com.ust.Talent_Post.repository;


import com.ust.Talent_Post.model.TalentPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TalentPostRepository extends MongoRepository<TalentPost, String> {
    List<TalentPost> findByDirectorId(String directorId);
}


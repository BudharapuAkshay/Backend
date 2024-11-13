package com.ust.Talent_Post.service;

import com.ust.Talent_Post.model.TalentPost;
import com.ust.Talent_Post.repository.TalentPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentPostService {

    @Autowired
    private TalentPostRepository repository;

    public TalentPost createPost(TalentPost post) {
        return repository.save(post);
    }

    public Optional<TalentPost> getPostById(String postId) {
        return repository.findById(postId);
    }

    public List<TalentPost> getAllPosts() {
        return repository.findAll();
    }

    public List<TalentPost> getPostsByDirector(String directorId) {
        return repository.findByDirectorId(directorId);
    }

    public TalentPost updatePost(String postId, TalentPost post) {
        post.setTalentPostId(postId);
        return repository.save(post);
    }

    public void deletePost(String postId) {
        repository.deleteById(postId);
    }
}

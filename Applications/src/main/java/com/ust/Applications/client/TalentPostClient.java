package com.ust.Applications.client;

import com.ust.Applications.dto.TalentPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Talent-Post", url = "http://localhost:5959")
public interface TalentPostClient {
    @GetMapping("/api/talent-posts/{postId}")
    TalentPost getPostById(@PathVariable String postId);
}
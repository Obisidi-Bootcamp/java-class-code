package com.bptn.repository;


import com.bptn.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Post, String> {

    List<Post> findAllByUsernameKey(String username);

    Post findById(long postID);

    List<Post> findByPostType(String postType);

}

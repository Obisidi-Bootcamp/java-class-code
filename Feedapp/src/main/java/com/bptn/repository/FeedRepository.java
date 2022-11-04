package com.bptn.repository;

import com.bptn.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Post, String> {

    List<Post> findByUsername(String username);

    Post findByPostID(String postID);

    List<Post> findByPostType(String postType);

}

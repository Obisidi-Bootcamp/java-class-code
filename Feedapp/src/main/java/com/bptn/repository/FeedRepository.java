package com.bptn.repository;

import com.bptn.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<Post, String> {

    List<Post> findByUsername(String username);

    Post findByPostID(String postID);

    List<Post> findByPostType(String postType);

}

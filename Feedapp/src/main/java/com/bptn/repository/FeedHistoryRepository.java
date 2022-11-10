package com.bptn.repository;

import com.bptn.models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedHistoryRepository extends JpaRepository<History, String> {

    List<History> findByUsername(String username);

    History findByPostId(String postID);

    History findByPostType(String postType);

    void deleteByPostType(String postType);


}

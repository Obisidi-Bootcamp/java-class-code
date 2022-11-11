package com.bptn.repository;

import com.bptn.models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FeedHistoryRepository extends JpaRepository<History, String> {

    List<History> findByUsername(String username);

    History findByPostId(String postID);

    List<History> findByPostType(String postType);

    @Transactional
    void deleteByPostType(String postType);


}

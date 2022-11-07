package com.bptn.repository;

import com.bptn.models.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedPostRepository extends FeedRepository {

    Post save(Post feed);

}

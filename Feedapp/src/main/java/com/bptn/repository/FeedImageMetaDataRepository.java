package com.bptn.repository;

import com.bptn.models.ImageMetaData;
import com.bptn.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {

    ImageMetaData findById(long imageId);

    List<ImageMetaData> findAllByPostKey(Post post);
}

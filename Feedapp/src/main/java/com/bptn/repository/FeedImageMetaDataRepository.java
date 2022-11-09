package com.bptn.repository;

import com.bptn.models.ImageMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {

    ImageMetaData findByImageid(String imageID);

    List<ImageMetaData> findByPostkey(String postkey);

}

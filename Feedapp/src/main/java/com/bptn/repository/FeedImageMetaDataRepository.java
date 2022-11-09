package com.bptn.repository;

import com.bptn.models.ImageMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {

    ImageMetaData findByImageid(String imageID); // where "imageid" = 'imageID';

    List<ImageMetaData> findByPostkey(String postkey);

}

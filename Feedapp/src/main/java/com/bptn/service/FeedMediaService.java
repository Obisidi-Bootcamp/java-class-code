package com.bptn.service;

import com.bptn.exceptions.InvalidImageMetaDataException;
import com.bptn.models.ImageMetaData;
import com.bptn.repository.FeedImageMetaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedMediaService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedImageMetaDataRepository feedImageMetaDataRepository;

    public List<ImageMetaData> getImageMediaByPostKey(String postkey) throws InvalidImageMetaDataException {

        LOGGER.info("retrieving ImageMedia from DB by postkey");

        List<ImageMetaData> media = feedImageMetaDataRepository.findByPostkey(postkey);

        if (media == null){
            throw new InvalidImageMetaDataException("Post Key does not exist");
        }

        media = removeEmptyImages(media);

        LOGGER.debug("FeedImageMetaDataService = {}", media);
        return media;
    }

    public ImageMetaData getPostsImageMediaByImageId(String imageID) throws InvalidImageMetaDataException {

        LOGGER.info("retrieving Image information from DB by imageID");

        ImageMetaData image = feedImageMetaDataRepository.findByImageid(imageID);

        if (image == null){
            throw new InvalidImageMetaDataException("ImageID doesn't exist");
        }

        LOGGER.debug("FeedImageMetaDataService = {}", image);
        return image;
    }


    public ImageMetaData createNewImage(ImageMetaData imageinfo){

            Optional<ImageMetaData> image = feedImageMetaDataRepository.findById(imageinfo.getImageid());
            if (image.isPresent()){
                ImageMetaData imageNew = image.get();
                imageNew.setImageid(imageinfo.getImageid());
                imageNew.setImagename(imageinfo.getImagename());
                imageNew.setImagesize(imageinfo.getImagesize());
                imageNew.setImageformat(imageinfo.getImageformat());
                imageNew.setImagedate(imageinfo.getImagedate());
                imageNew.setResolution(imageinfo.getResolution());
                imageNew.setPostkey(imageinfo.getPostkey());
                imageNew = feedImageMetaDataRepository.save(imageNew);
                return imageNew;
            } else{
                imageinfo = feedImageMetaDataRepository.save(imageinfo);
                return imageinfo;
            }
    }

    private List<ImageMetaData> removeEmptyImages(List<ImageMetaData> media) {
        List<ImageMetaData> resultImages = new LinkedList<>();

        for (ImageMetaData img: media){
            if (img.getImageid() != null && !img.getImageid().isEmpty()){
                resultImages.add(img);
            }
        }
        return resultImages;
    }
}

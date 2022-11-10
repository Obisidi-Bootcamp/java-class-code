package com.bptn.service;

import com.bptn.exceptions.InvalidImageMetaDataException;
import com.bptn.models.ImageMetaData;
import com.bptn.repository.FeedImageMetaDataRepository;
import com.bptn.request.FeedMediaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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


    public ImageMetaData createNewImage(FeedMediaRequest imageinfo) {

        String postkey = imageinfo.getPostkey();
        String imageid = generateFeedMetadataId(postkey);

        Optional<ImageMetaData> image = feedImageMetaDataRepository.findById(imageid);
        ImageMetaData imageNew;

        if (image.isPresent()) {
            imageNew = image.get();
        } else {
            imageNew = new ImageMetaData();
            imageNew.setImageid(imageid);
        }

        imageNew.setImagename(imageinfo.getImageName());
        imageNew.setImagesize(imageinfo.getImageSize());
        imageNew.setImageformat(imageinfo.getImageFormat());
        imageNew.setImagedate(LocalDate.now()+"");
        imageNew.setResolution(imageinfo.getResolution());
        imageNew.setPostkey(postkey);
        imageNew = feedImageMetaDataRepository.save(imageNew);
        return imageNew;

        }


    private String generateFeedMetadataId(String postkey) {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder imageIdBuilder = new StringBuilder();
        imageIdBuilder.append(random.nextInt());
        imageIdBuilder.append(Objects.hashCode(postkey));
        String imageId = imageIdBuilder.toString();

        if (imageId.startsWith("-")){
            return imageId.substring(1);
        }
        return imageId;
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

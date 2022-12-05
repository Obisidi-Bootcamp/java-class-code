package com.bptn.controller;

import com.bptn.exceptions.InvalidImageMetaDataException;
import com.bptn.exceptions.InvalidPostException;
import com.bptn.models.ImageMetaData;
import com.bptn.models.Post;
import com.bptn.request.FeedMediaRequest;
import com.bptn.service.FeedMediaService;
import com.bptn.service.FeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FeedMediaController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedMediaService feedMediaService;

    @Autowired
    private FeedService feedService;

    @GetMapping(value = "/image/metadata/{postKey}")
    public ResponseEntity<Object> getImageMediaByPostKey(@PathVariable("postKey") long postKey) {

        LOGGER.debug("Executing getImageMediaByPostKey API");
        List<ImageMetaData> imageMetaDataList;
        try {
            imageMetaDataList = feedMediaService.getImageMediaByPostKey(postKey);
        } catch (Exception e) {
            LOGGER.error("Unable to find Image Metadata by postkey, cause={}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(imageMetaDataList, HttpStatus.OK);
    }


    @GetMapping(value = "/imageInfo/metadata/{imageID}")
    public ResponseEntity<Object> getPostsImageMediaByImageId(@PathVariable("imageID") long imageID) {
        LOGGER.debug("Executing getPostsImageMediaByImageId API");
        ImageMetaData imageMetaData;
        try {
            imageMetaData = feedMediaService.getPostsImageMediaByImageId(imageID);
        } catch (InvalidImageMetaDataException exception) {
            LOGGER.error("Unable to find image metadata by imageId, cause= {}", exception.getCause());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        return new ResponseEntity<>(imageMetaData, HttpStatus.OK);
    }


    @PostMapping(value = "/image/metadata", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> createNewImage(@RequestBody FeedMediaRequest feedMediaRequest) throws InvalidPostException {
        LOGGER.debug("Executing createNewImage API");
        ImageMetaData imageMetaData = requestToEntity(feedMediaRequest);
        imageMetaData = feedMediaService.createNewImage(imageMetaData);
        return new ResponseEntity<>(imageMetaData, HttpStatus.OK);
    }

    private ImageMetaData requestToEntity(FeedMediaRequest feedMediaRequest) throws InvalidPostException {
        ImageMetaData imageMetaData = new ImageMetaData();
        imageMetaData.setImageDate(LocalDate.now() + "");
        imageMetaData.setImageFormat(feedMediaRequest.getImageFormat());
        imageMetaData.setImageName(feedMediaRequest.getImageName());
        imageMetaData.setImageSize(feedMediaRequest.getImageSize());
        imageMetaData.setResolution(feedMediaRequest.getResolution());
        Post post = feedService.getPostsByPostId(Long.parseLong(feedMediaRequest.getPostkey()));
        imageMetaData.setPostKey(post);
        return imageMetaData;
    }


}
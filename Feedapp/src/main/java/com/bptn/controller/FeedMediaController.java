package com.bptn.controller;


import com.bptn.exceptions.InvalidImageMetaDataException;
import com.bptn.models.ImageMetaData;
import com.bptn.service.FeedMediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FeedMediaController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedMediaService feedMediaService;

    @GetMapping(value = "/image/metadata/{postKey}")
    public ResponseEntity<Object> getImageMediaByPostKey(@PathVariable("postKey") String postkey) {

        LOGGER.debug("Executing getImageMediaByPostKey API ");

        List<ImageMetaData> imageMetaDataList;

        try{
            imageMetaDataList = feedMediaService.getImageMediaByPostKey(postkey);
        } catch (InvalidImageMetaDataException e){
            LOGGER.error("Unable to find image Metadata by postkey, cause={}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(imageMetaDataList, HttpStatus.OK);

    }

    @GetMapping(value = "/imageInfo/metadata/{imageID}")
    public ResponseEntity<Object> getImageMediaByImageId(@PathVariable("imageID") String imageID) {
        LOGGER.debug("Executing getImageMediaByImageId API");

        ImageMetaData imageMetaData;

        try {
            imageMetaData = feedMediaService.getPostsImageMediaByImageId(imageID);
        } catch (InvalidImageMetaDataException e){
            LOGGER.error("Unable to find image metadata by imageId, cause={}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(imageMetaData, HttpStatus.OK);
    }




}

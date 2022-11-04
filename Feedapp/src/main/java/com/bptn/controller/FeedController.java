package com.bptn.controller;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.Post;
import com.bptn.service.FeedService;
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
public class FeedController {
    Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedService feedService;

    @GetMapping("/")
    public ResponseEntity<String> ping(){

        logger.debug("Executing ping()");

        return new ResponseEntity<String>("feedapp up and running",HttpStatus.OK);

    }

    @GetMapping(value="/Posts/username/{username}")
    public ResponseEntity<Object> getPostsByUsername(@PathVariable("username") String username) {

        logger.info("Executing getPostByUsername API");

        List<Post> feeds;

        try {
            feeds = feedService.getPostsByUsername(username);
        } catch (InvalidUserNameException e){
            logger.error("Unable to find post by username, cause={}",e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(feeds,HttpStatus.OK);

    }

    @GetMapping(value="/Posts/postID/{postID}")
    public ResponseEntity<Object> getPostsByPostId(@PathVariable("postID") String postID){
        logger.info("Executing getPostByPostId API");

        Post feed;
        try {
            feed = feedService.getPostsByPostId(postID);
        } catch (InvalidPostException e){
            logger.error("Unable to find post by postID, cause={}",e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(feed,HttpStatus.OK);
    }

    @GetMapping(value ="/Posts/postType/{postType}")
    public ResponseEntity<Object> getPostsByPostType(@PathVariable("postType") String postType){
        logger.info("Executing getPostByPostType API");

        List<Post> feeds;

        try {
            feeds = feedService.getPostsByPostType(postType);
        } catch (InvalidPostException e){
            logger.error("Unable to find post by postType, cause={}",e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(feeds,HttpStatus.OK);

    }



}

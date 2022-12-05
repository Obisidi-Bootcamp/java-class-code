package com.bptn.controller;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.Post;
import com.bptn.request.CreatePostRequest;
import com.bptn.service.FeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FeedController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedService feedService;

    @GetMapping(value = "/")
    public ResponseEntity<String> ping() {
        LOGGER.debug("Executing ping()");
        return new ResponseEntity("Feed App up and running", HttpStatus.OK);
    }

    @GetMapping(value = "/Posts/username/{username}")
    public ResponseEntity<Object> getPostsByUsername(@PathVariable("username") String username) {
        LOGGER.debug("Executing getPostsByUsername API");
        List<Post> feeds;
        try {
            feeds = feedService.getPostsByUsername(username);
        } catch (InvalidUserNameException e) {
            LOGGER.error("Unable to find Post by Username, cause={}", e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(feeds, HttpStatus.OK);
    }

    @GetMapping(value = "/Posts")
    public ResponseEntity<Object> getAllPost(@RequestParam String excludeUsername) {
        LOGGER.debug("Executing getAllPost API and excluding user = {}", excludeUsername);
        List<Post> feeds = feedService.getAllPost(excludeUsername);
        return new ResponseEntity<>(feeds, HttpStatus.OK);
    }


    @PostMapping(value = "/Posts/username/{username}")
    public ResponseEntity<Object> createUserPost(@PathVariable("username") String username, @RequestBody CreatePostRequest createPostRequest) {
        LOGGER.debug("Executing createUserPost API");
        Post feed = feedService.createUserPost(username, createPostRequest);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }


    @GetMapping(value = "/Posts/postID/{postID}")
    public ResponseEntity<Object> getPostsByPostId(@PathVariable("postID") long postID) {
        LOGGER.debug("Executing getPostsByPostId API");
        Post feed;
        try {
            feed = feedService.getPostsByPostId(postID);
        } catch (InvalidPostException e) {
            LOGGER.error("Unable to find Post by postID, cause={}", e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @GetMapping(value = "/Posts/postType/{postType}")
    public ResponseEntity<Object> getPostsByPostType(@PathVariable("postType") String postType) {
        LOGGER.debug("Executing getPostsByPostType API");
        List<Post> feed;
        try {
            feed = feedService.getPostsByPostType(postType);
        } catch (InvalidPostException e) {
            LOGGER.error("Unable to find Post by postType, cause={}", e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }
}
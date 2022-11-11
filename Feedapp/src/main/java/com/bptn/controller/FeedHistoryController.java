package com.bptn.controller;

import com.bptn.exceptions.InvalidHistoryException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.History;
import com.bptn.service.FeedHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class FeedHistoryController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FeedHistoryService feedHistoryService;
    @GetMapping(value = "/history/userName/{username}")
    public ResponseEntity<Object> getPostsByUsername(@PathVariable("username") String username) {
        LOGGER.debug("Executing getPostsByUsername API");
        List<History> feeds;
        try {
            feeds = feedHistoryService.getPostsByUsername(username);
        } catch (InvalidUserNameException e) {
            LOGGER.error("Unable to find History by Username, cause={}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(feeds, HttpStatus.OK);
    }
    @GetMapping(value = "/history/postID/{postID}")
    public ResponseEntity<Object> getPostsByPostId(@PathVariable("postID") String postID) {
        LOGGER.debug("Executing getPostsByPostId API");
        History feed;
        try {
            feed = feedHistoryService.getPostsByPostId(postID);
        } catch (InvalidHistoryException exception) {
            LOGGER.error("Unable to find History by postId, cause={}", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }
    @GetMapping(value = "/history/postType/{postType}")
    public ResponseEntity<Object> getPostsByPostType(@PathVariable("postType") String postType) {
        LOGGER.debug("Executing getPostsByPostType API");
        List<History> feed;
        try {
            feed = feedHistoryService.getPostsByPostType(postType);
        } catch (InvalidHistoryException exception) {
            LOGGER.error("Unable to find History by postType, cause={}", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }
    @DeleteMapping(value = "/history/delete/postType/{postType}")
    public ResponseEntity<Object> deletePostsByPostType(@PathVariable("postType") String postType) {
        LOGGER.debug("Executing deletePostsByPostType API");
        try {
            feedHistoryService.deleteHistoryByPostType(postType);
        } catch (InvalidHistoryException e) {
            LOGGER.error("Unable to find History by postType, cause={}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("history deleted successfully");
    }
}

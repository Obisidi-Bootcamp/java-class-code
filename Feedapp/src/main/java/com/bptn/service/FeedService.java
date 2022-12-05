package com.bptn.service;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.ImageMetaData;
import com.bptn.models.Post;
import com.bptn.repository.FeedImageMetaDataRepository;
import com.bptn.repository.FeedRepository;
import com.bptn.request.CreatePostRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static com.bptn.request.CreatePostRequest.DEFAULT_POST_TYPE;

@Service
public class FeedService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private FeedImageMetaDataRepository feedImageMetaDataRepository;

    @Autowired
    private UserService userService;

    public List<Post> getPostsByUsername(String username) throws InvalidUserNameException {
        LOGGER.info("retrieving Posts from DB by username");
        userService.validateUserId(username);
        List<Post> posts = feedRepository.findAllByUsernameKey(username);
        posts = removeEmptyPosts(posts);
        LOGGER.debug("Feeds={}", posts);
        return posts;
    }

    public Post getPostsByPostId(long postID) throws InvalidPostException {
        LOGGER.info("retrieving Posts from DB by postId");
        Post post = feedRepository.findById(postID);
        if (post == null) {
            throw new InvalidPostException("PostID doesn't exist");
        }
        LOGGER.debug("Feed={}", post);
        return post;
    }

    public List<Post> getPostsByPostType(String postType) throws InvalidPostException {
        LOGGER.info("retrieving Posts from DB by postType");
        List<Post> post = feedRepository.findByPostType(postType);
        if (post == null) {
            throw new InvalidPostException("PostType doesn't exist");
        }
        LOGGER.debug("Feed={}", post);
        return post;
    }

    private List<Post> removeEmptyPosts(List<Post> posts) {
        List<Post> resultPosts = new LinkedList<>();
        for (Post post : posts) {
            if (post.getPost() != null && !post.getPost().isEmpty()) {
                resultPosts.add(post);
            }
        }
        return resultPosts;
    }

    public List<Post> getAllPost(String excludeUsername) {
        List<Post> allfeeds =  feedRepository.findAll();
        List<Post> results = new LinkedList<>();
        for (Post post : allfeeds){
            if(!post.getUsernameKey().equals(excludeUsername)){
                results.add(post);
            }
        }
        return results;
    }

    @Transactional
    public Post createUserPost(String username, CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setUsernameKey(username);
        post.setPostType(DEFAULT_POST_TYPE);
        post.setPost(createPostRequest.getPost());
        post = feedRepository.save(post);
        ImageMetaData imageMetaData = new ImageMetaData();
        imageMetaData.setImageDate(LocalDate.now() + "");
        imageMetaData.setImageName(createPostRequest.getImageUrl());
        imageMetaData.setResolution(StringUtils.EMPTY);
        imageMetaData.setImageSize(StringUtils.EMPTY);
        imageMetaData.setImageFormat(StringUtils.EMPTY);
        imageMetaData.setPostKey(post);
        imageMetaData = feedImageMetaDataRepository.save(imageMetaData);
        post.getImageMetaData().add(imageMetaData);
        return post;
    }
}
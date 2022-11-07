package com.bptn.service;

import com.bptn.models.Post;
import com.bptn.repository.FeedPostRepository;
import com.bptn.request.FeedPostRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Random;

    @Service
    public class FeedPostService {

        private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

        @Value("${api.key}")
        private String apiKey;

        @Value("${api.base.url}")
        private String apiBaseUrl;

        private static final String POST_TYPE = "news";

        @Autowired
        private FeedPostRepository feedPostRepository;

        public Post getPostFromNewsAndSavePost(FeedPostRequest feedPostRequest) {
            String url = buildApiUrl(feedPostRequest);
            LOGGER.debug("News Feed URL = {}", url);
            String feedResult = getFeedFromNewsAPI(url);
            return storeFeed(feedResult, feedPostRequest);
        }

        private Post storeFeed(String feedResult, FeedPostRequest feedPostRequest) {
            Post feed = new Post();
            feed.setPost(feedResult);
            feed.setPostType(POST_TYPE);
            feed.setUsername(feedPostRequest.getUserName());
            feed.setPostID(generatePostId(feedPostRequest));
            LOGGER.debug("Feed to be stored : {}", feed);
            return feedPostRepository.save(feed);
        }

        private String generatePostId(FeedPostRequest feedPostRequest) {
            Random random = new Random(System.currentTimeMillis());
            StringBuilder postIdBuilder = new StringBuilder();
            postIdBuilder.append(random.nextInt());
            postIdBuilder.append(Objects.hashCode(feedPostRequest.getUserName() + " " + feedPostRequest.getQueryKeyword()));
            String postId = postIdBuilder.toString();
            if (postId.startsWith("-")) {
                return postId.substring(1);
            }
            return postId;
        }

        private String getFeedFromNewsAPI(String url) {
            RestTemplate restTemplate = new RestTemplate();
            String result = "";
            try {
                result = restTemplate.getForObject(url, String.class);
            } catch(RestClientException e){
                e.printStackTrace();
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            assert result != null;
            JsonElement jsonElement = JsonParser.parseString(result);
            return gson.toJson(jsonElement.getAsJsonObject().get("articles").getAsJsonArray().get(0).getAsJsonObject().get("description"));
        }

        private String buildApiUrl(FeedPostRequest feedPostRequest) {
            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append(apiBaseUrl);
            urlBuilder.append("?q=").append(feedPostRequest.getQueryKeyword());
            if (feedPostRequest.getFromDate() != null && !feedPostRequest.getFromDate().isEmpty()) {
                urlBuilder.append("&from=").append(feedPostRequest.getFromDate());
            }
            if (feedPostRequest.getToDate() != null && !feedPostRequest.getToDate().isEmpty()) {
                urlBuilder.append("&to=").append(feedPostRequest.getToDate());
            }
            urlBuilder.append("&apiKey=").append(apiKey);
            return urlBuilder.toString();
        }
}

package com.bptn.request;

public class CreatePostRequest {

    public static final String DEFAULT_POST_TYPE = "TEXT";

    private String imageUrl;
    private String post;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}

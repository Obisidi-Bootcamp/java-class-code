package com.bptn.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"History\"")
public class History {

    @Id
    @Column(name = "\"postID\"")
    private String postId;

    @Column(name = "\"usernameKey\"")
    private String username;

    @Column(name = "\"date\"")
    private String date;

    @Column(name = "\"postType\"")
    private String postType;

    @Column(name = "\"postUpload\"")
    private String postUpload;

    public History(){
        super();
    }

    public History(String postId, String username, String date, String postType, String postUpload) {
        super();
        this.postId = postId;
        this.username = username;
        this.date = date;
        this.postType = postType;
        this.postUpload = postUpload;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostUpload() {
        return postUpload;
    }

    public void setPostUpload(String postUpload) {
        this.postUpload = postUpload;
    }
}

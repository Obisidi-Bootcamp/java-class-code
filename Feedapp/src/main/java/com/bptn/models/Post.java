package com.bptn.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "\"Post\"")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"postID\"", nullable = false)
    private Long id;

    @Column(name = "\"postType\"", nullable = false)
    private String postType;


    @Column(name = "post", nullable = false)
    private String post;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "\"usernameKey\"", nullable = false)
    private String usernameKey;

    @OneToMany(mappedBy = "postKey")
    @JsonManagedReference
    private Set<ImageMetaData> imageMetaData = new LinkedHashSet<>();

    public Set<ImageMetaData> getImageMetaData() {
        return imageMetaData;
    }

    public void setImageMetaData(Set<ImageMetaData> imageMetaData) {
        this.imageMetaData = imageMetaData;
    }

    public String getUsernameKey() {
        return usernameKey;
    }

    public void setUsernameKey(String usernameKey) {
        this.usernameKey = usernameKey;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
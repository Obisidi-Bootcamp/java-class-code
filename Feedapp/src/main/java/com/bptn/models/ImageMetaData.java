package com.bptn.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"ImageMetaData\"")
@NamedQuery(name="ImageMetaData.findAll", query="SELECT i FROM ImageMetaData i")
public class ImageMetaData implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"imageID\"", nullable = false)
    private Long id;


    @Column(name = "\"imageName\"", nullable = false)
    private String imageName;


    @Column(name = "\"imageSize\"", nullable = false)
    private String imageSize;


    @Column(name = "\"imageFormat\"", nullable = false)
    private String imageFormat;


    @Column(name = "\"imageDate\"", nullable = false)
    private String imageDate;


    @Column(name = "resolution", nullable = false)
    private String resolution;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"postKey\"", nullable = false)
    @JsonBackReference
    private Post postKey;

    public Post getPostKey() {
        return postKey;
    }

    public void setPostKey(Post postKey) {
        this.postKey = postKey;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getImageDate() {
        return imageDate;
    }

    public void setImageDate(String imageDate) {
        this.imageDate = imageDate;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

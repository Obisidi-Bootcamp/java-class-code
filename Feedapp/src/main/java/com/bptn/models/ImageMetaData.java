package com.bptn.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"ImageMetaData\"")
public class ImageMetaData {

    @Id
    @Column(name = "\"imageID\"")
    private String imageid;

    @Column(name = "\"imageName\"")
    private String imagename;

    @Column(name = "\"imageSize\"")
    private String imagesize;

    @Column(name = "\"imageFormat\"")
    private String imageformat;

    @Column(name = "\"imageDate\"")
    private String imagedate;

    @Column(name = "\"resolution\"")
    private String resolution;

    // Annotate for the foreign key
    @Column(name = "\"postKey\"")
    private String postkey;


    public ImageMetaData(){
        super();
    }

    public ImageMetaData(String imageid, String imagename, String imagesize, String imageformat, String imagedate,
                         String resolution, String postkey){

        this.imageid = imageid;
        this.imagename = imagename;
        this.imagesize = imagesize;
        this.imageformat = imageformat;
        this.imagedate = imagedate;
        this.resolution = resolution;
        this.postkey = postkey;

    }

    public String getImageid(){
        return this.imageid;
    }

    public void setImageid(String imageid){
        this.imageid = imageid;
    }

    public String getImagename(){
        return this.imagename;
    }

    public void setImagename(String imagename){
        this.imagename = imagename;
    }

    public String getImagesize(){
        return this.imagesize;
    }

    public void setImagesize(String imagesize){
        this.imagesize = imagesize;
    }

    public String getImageformat(){
        return this.imageformat;
    }

    public void setImageformat(String imageformat){
        this.imageformat = imageformat;
    }

    public String getImagedate(){
        return this.imagedate;
    }

    public void setImagedate(String imagedate){
        this.imagedate = imagedate;
    }

    public String getResolution(){
        return this.resolution;
    }

    public void setResolution(String resolution){
        this.resolution = resolution;
    }

    public String getPostkey(){
        return this.postkey;
    }

    public void setPostkey(String postkey){
        this.postkey = postkey;
    }









}

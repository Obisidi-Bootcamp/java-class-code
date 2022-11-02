package com.bptn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"UserID\"")
public class UserID {

    @Column(name = "\"name\"")
    private String name;

    @Column(name = "\"emailID\"")
    private String emailID;

    @Column(name = "\"phoneNumber\"")
    private String phoneNumber;

    @Column(name = "\"userPassword\"")
    private String userPassword;

    @Id
    @Column(name = "\"username\"")
    private String username;


    public UserID(){
        super();
    }


    public UserID(String name, String emailID, String phoneNumber, String userPassword, String username){
        super();
        this.name = name;
        this.emailID = emailID;
        this.phoneNumber = phoneNumber;
        this.userPassword = userPassword;
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return this.emailID;
    }

    public void setEmailID(String emailID){
        this.emailID = emailID;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPassword(){
        return this.userPassword;
    }

    public void setPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }







}

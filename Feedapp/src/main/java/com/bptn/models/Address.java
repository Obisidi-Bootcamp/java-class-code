package com.bptn.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"Address\"")
public class Address {

    @Column(name = "\"address\"")
    private String address;

    @Column(name = "\"city\"")
    private String city;

    @Column(name = "\"state\"")
    private String state;

    @Column(name = "\"country\"")
    private String country;

    @Column(name = "\"pincode\"")
    private String pincode;

    @Id
    @Column(name = "\"usernameKey\"")
    private String username;

    public Address(){
        super();
    }

    public Address(String address, String city, String state, String country, String pincode, String username){
        super();
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

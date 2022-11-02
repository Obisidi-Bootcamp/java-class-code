package com.bptn.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"Profile\"")
public class Profile {

    @Column(name = "\"position\"" )
    private String position;

    @Column(name = "\"company\"" )
    private String company;

    @Column(name = "\"companyAddress\"" )
    private String companyaddress;

    @Column(name = "\"interests\"" )
    private String interests;

    @Column(name = "\"experience\"" )
    private String experience;

    @Column(name = "\"education\"" )
    private String education;

    @Column(name = "\"certification\"" )
    private String certification;

    @Column(name = "\"skills\"" )
    private String skills;

    @Column(name = "\"languages\"" )
    private String languages;

    @Id
    @Column(name = "\"usernameKey\"" )
    private String username;


    public Profile() {
        super();
    }

    public Profile(String position, String company, String companyaddress, String interests, String experience, String education, String certification, String skills, String languages, String username) {
        super();
        this.position = position;
        this.company = company;
        this.companyaddress = companyaddress;
        this.interests = interests;
        this.experience = experience;
        this.education = education;
        this.certification = certification;
        this.skills = skills;
        this.languages = languages;
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getinterests() {
        return interests;
    }

    public void setinterests(String interests) {
        this.interests = interests;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

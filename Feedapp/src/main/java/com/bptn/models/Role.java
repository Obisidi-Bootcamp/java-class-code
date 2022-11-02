package com.bptn.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"Role\"")
public class Role {

    @Column(name = "\"role\"")
    private String role;

    @Column(name = "\"company\"")
    private String company;

    @Column(name = "\"skills\"")
    private String skills;

    @Id
    @Column(name = "\"usernameKey\"")
    private String username;

    public Role(){
        super();
    }

    public Role(String role, String company, String skills, String username) {
        super();
        this.role = role;
        this.company = company;
        this.skills = skills;
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

package com.bptn.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"Role\"")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RoleId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"usernameKey\"", nullable = false, insertable=false, updatable = false)
    @JsonBackReference
    private UserID usernameKey;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "skills", nullable = false)
    private String skills;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public UserID getUsernameKey() {
        return usernameKey;
    }

    public void setUsernameKey(UserID usernameKey) {
        this.usernameKey = usernameKey;
    }

    public RoleId getId() {
        return id;
    }

    public void setId(RoleId id) {
        this.id = id;
    }
}
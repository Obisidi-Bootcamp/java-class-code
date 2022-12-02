package com.bptn.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoleId implements Serializable {
    private static final long serialVersionUID = 6392747291828750508L;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "\"usernameKey\"", nullable = false)
    private String usernameKey;

    public String getUsernameKey() {
        return usernameKey;
    }

    public void setUsernameKey(String usernameKey) {
        this.usernameKey = usernameKey;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoleId entity = (RoleId) o;
        return Objects.equals(this.usernameKey, entity.usernameKey) &&
                Objects.equals(this.role, entity.role);
    }
}


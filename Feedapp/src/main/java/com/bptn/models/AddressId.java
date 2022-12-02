package com.bptn.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AddressId implements Serializable {
    private static final long serialVersionUID = -214280011402490730L;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "pincode", nullable = false)
    private String pincode;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == (AddressId)o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AddressId entity = (AddressId) o;
        return Objects.equals(this.pincode, entity.pincode) &&
                Objects.equals(this.address, entity.address);
    }
}

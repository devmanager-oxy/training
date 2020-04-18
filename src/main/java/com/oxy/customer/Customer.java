package com.oxy.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oxy.util.GlobalEntity;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer extends GlobalEntity {

    public Customer(){}

    public Customer(String name){
        this.name = name;
    }

    @Column(name = "name", length = 50)
    @Size(max = 50)
    private String name;

    @Column(name ="address", length = 255)
    @JsonProperty("customer_address")
    @NotNull
    private String address;

    @Transient
    private String nameAdress;

    @Column(name="email", unique = true)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

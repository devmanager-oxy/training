package com.oxy.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

    public Customer(){}

    public Customer(String name){
        this.name = name;
    }

    @Id
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

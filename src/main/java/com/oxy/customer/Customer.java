package com.oxy.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    public Customer(){}

    public Customer(String name){
        this.name = name;
    }

    @Id
    private String id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name ="address", length = 255)
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

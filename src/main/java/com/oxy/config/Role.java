package com.oxy.config;

import com.oxy.util.GlobalEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = { @JoinColumn(name="role_id")},
    inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")})
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
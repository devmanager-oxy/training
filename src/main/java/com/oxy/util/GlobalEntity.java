package com.oxy.util;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class GlobalEntity {

    private static final int ACTIVE = 1;

    @Id
    private String id;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name= "status")
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = new Date();
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = new Date();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }
}

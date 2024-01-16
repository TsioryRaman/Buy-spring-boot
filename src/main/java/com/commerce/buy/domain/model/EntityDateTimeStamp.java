package com.commerce.buy.domain.model;

import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@MappedSuperclass
public class EntityDateTimeStamp {

    @CreationTimestamp
    private Date created_at;
    @UpdateTimestamp
    public Date updated_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
//
//    @PreUpdate
//    public void preUpdatedAt()
//    {
//        this.updated_at = new Date();
//    }
}

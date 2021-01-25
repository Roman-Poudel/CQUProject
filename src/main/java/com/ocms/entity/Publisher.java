package com.ocms.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="tbl_publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    private String publisherID;

    @NotNull
    private String publisherName;

    public Publisher(){}

    public Publisher(String publisherID, String publisherName) {
        this.publisherID = publisherID;
        this.publisherName = publisherName;
    }

    public String getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}

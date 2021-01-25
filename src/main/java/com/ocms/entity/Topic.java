package com.ocms.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="tbl_topic")
public class Topic {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    private String topicID;

    @NotNull
    private String topicName;

    public Topic(){}

    public Topic(String topicID, String topicName) {
        this.topicID = topicID;
        this.topicName = topicName;
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}

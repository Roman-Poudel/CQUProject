package com.ocms.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Data
@DynamicUpdate
@Table(name="tbl_paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String paperID;

    @NotNull
    private String paperTitle;

    @NotNull
    private String paperTopic;

    @NotNull
    private String paperPublisher;


    @NotNull
    private String country;


    @NotNull
    private String paperStatus = "RECEIVED";

    @NotNull
    @Column(insertable=true, updatable = false)
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;


    @NotNull
    private TimeZone timzone;


    @PrePersist
    void onCreate(){
        ZonedDateTime timezone= ZonedDateTime.now();
        this.setTimzone(TimeZone.getTimeZone(timezone.getZone()));
        this.setCreatedTime(LocalDateTime.now());
        this.setModifiedTime(LocalDateTime.now());

    }

    @PreUpdate
    void onUpdate(){
        ZonedDateTime timezone= ZonedDateTime.now();
        this.setModifiedTime(LocalDateTime.now());
        this.setTimzone(TimeZone.getTimeZone(timezone.getZone().getId()));
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uID", referencedColumnName = "uID")
    private User user;

    public Paper(){}

    public Paper(String paperTitle, String paperTopic, String paperPublisher, String country,
                 String paperStatus, User user) {
        this.paperTitle = paperTitle;
        this.paperTopic = paperTopic;
        this.paperPublisher = paperPublisher;
        this.country=country;
        this.paperStatus = paperStatus;
        this.user = user;


    }

    public String getPaperID() {
        return paperID;
    }

    public void setPaperID(String paperID) {
        this.paperID = paperID;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperTopic() {
        return paperTopic;
    }

    public void setPaperTopic(String paperTopic) {
        this.paperTopic = paperTopic;
    }

    public String getPaperPublisher() {
        return paperPublisher;
    }

    public void setPaperPublisher(String paperPublisher) {
        this.paperPublisher = paperPublisher;
    }

    public String getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(String paperStatus) {
        this.paperStatus = paperStatus;
    }

    public void setUser(User user) {
        user = user;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public TimeZone getTimzone() {
        return timzone;
    }


    public void setTimzone(TimeZone timzone) {
        this.timzone = timzone;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Paper{" +
                "paperID='" + paperID + '\'' +
                ", paperTitle='" + paperTitle + '\'' +
                ", paperTopic='" + paperTopic + '\'' +
                ", paperPublisher='" + paperPublisher + '\'' +
                ", paperStatus='" + paperStatus + '\'' +
                ", user=" + user +
                '}';
    }

}

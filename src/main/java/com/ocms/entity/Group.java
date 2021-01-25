package com.ocms.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="tbl_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String groupID;

    @NotNull
    private String groupName;

    @NotNull
    private String createdBy;



    @OneToMany(targetEntity = User.class,
            fetch = FetchType.EAGER)
    private List<User> member;

//    @OneToOne(targetEntity = Conference.class,
//            fetch = FetchType.EAGER)
//    private Conference conference;


    public Group(String groupName, String createdBy, List<User> member) {
        this.groupName = groupName;
        this.createdBy = createdBy;
        this.member = member;
    }
    public Group(){}

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getMember() {
        return member;
    }

    public void setMember(List<User> member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID='" + groupID + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", member='" + member + '\'' +
                '}';
    }

}

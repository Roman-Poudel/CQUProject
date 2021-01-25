package com.ocms.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    String groupMemberID;

    @NotNull
    String groupID;

    @NotNull
    String memberID;

    public GroupMember(String groupID, String memberID) {
        this.groupID = groupID;
        this.memberID = memberID;
    }

    public GroupMember(){}


    public String getGroupMemberID() {
        return groupMemberID;
    }

    public void setGroupMemberID(String groupMemberID) {
        this.groupMemberID = groupMemberID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
                "groupMemberID='" + groupMemberID + '\'' +
                ", groupID='" + groupID + '\'' +
                ", memberID='" + memberID + '\'' +
                '}';
    }


}

package com.ocms.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name= "tbl_organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String orgID;

    @NotNull
    private String orgName;

    public Organization(){}

    public Organization(String orgID, String orgName) {
        this.orgID = orgID;
        this.orgName = orgName;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}

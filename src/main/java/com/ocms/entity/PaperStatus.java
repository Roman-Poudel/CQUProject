package com.ocms.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class PaperStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String statusID;

    @NotNull
    private String statusName;

    public PaperStatus(){}

    public PaperStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

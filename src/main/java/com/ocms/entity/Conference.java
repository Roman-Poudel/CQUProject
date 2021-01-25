package com.ocms.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name="tbl_conference")
public class Conference {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    private String conferenceID;

    @NotNull
    private String conferenceName;

    @NotNull
    private String conferenceTheme;

    @NotNull
    private String conferenceDescription;

//    @OneToOne
//    private Group group;

    public Conference(String conferenceID, String conferenceName, String conferenceTheme, String conferenceDescription) {
        this.conferenceID = conferenceID;
        this.conferenceName = conferenceName;
        this.conferenceTheme = conferenceTheme;
        this.conferenceDescription = conferenceDescription;
    }

    public Conference() {
    }

    public String getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(String conferenceID) {
        this.conferenceID = conferenceID;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceTheme() {
        return conferenceTheme;
    }

    public void setConferenceTheme(String conferenceTheme) {
        this.conferenceTheme = conferenceTheme;
    }

    public String getConferenceDescription() {
        return conferenceDescription;
    }

    public void setConferenceDescription(String conferenceDescription) {
        this.conferenceDescription = conferenceDescription;
    }
}

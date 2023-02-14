package com.ocms.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String uID;
    @NotNull
    private String uName;
    @NotNull
    private String email;
    @NotNull
    @Column(name = "password")
    private String password;
    @NotNull
    private String country;
    @NotNull
    private String organization;

    @OneToMany(targetEntity = Paper.class,
            fetch = FetchType.EAGER)
    private List<Paper> papers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groupID", referencedColumnName = "groupID")
    private Group group;

    public User(String uName, String email, String password, String country,
                String organization, List<Paper> papers, Group group) {
        this.uName = uName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.organization = organization;
        this.papers = papers;
        this.group = group;
    }

    public User() {
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID='" + uID + '\'' +
                ", uName='" + uName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", organization='" + organization + '\'' +
                ", papers=" + papers +
                '}';
    }


}

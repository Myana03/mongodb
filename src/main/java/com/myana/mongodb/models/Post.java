package com.myana.mongodb.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobpost")
public class Post {

    @Id
    private String id;

    private String desc;
    private int exp;
    private String profile;
    private List<String> techs;

    // No-args constructor (required)
    public Post() {
    }

    // All-args constructor
    public Post(String id, String desc, int exp, String profile, List<String> techs) {
        this.id = id;
        this.desc = desc;
        this.exp = exp;
        this.profile = profile;
        this.techs = techs;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<String> getTechs() {
        return techs;
    }

    public void setTechs(List<String> techs) {
        this.techs = techs;
    }
}


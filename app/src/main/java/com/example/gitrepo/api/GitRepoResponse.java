package com.example.gitrepo.api;

import com.google.gson.annotations.SerializedName;

public class GitRepoResponse {
    @SerializedName("repository_url")
    private String repository_url;

    @SerializedName("user")
    private User user;


    @SerializedName("state")
    private String state;

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

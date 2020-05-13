package com.example.gitrepo.api;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private String id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

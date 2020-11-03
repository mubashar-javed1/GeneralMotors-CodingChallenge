package com.mubashar.generalmotorcodingchallenge.model;

import com.google.gson.annotations.SerializedName;

public class Author {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("date")
    private String date;

    public Author() {
        // default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
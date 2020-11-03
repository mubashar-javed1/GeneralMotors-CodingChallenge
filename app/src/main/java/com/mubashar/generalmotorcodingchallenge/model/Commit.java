package com.mubashar.generalmotorcodingchallenge.model;

import com.google.gson.annotations.SerializedName;

public class Commit {
    @SerializedName("author")
    private Author author;
    @SerializedName("message")
    private String message;

    public Commit() {
        // default constructor
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

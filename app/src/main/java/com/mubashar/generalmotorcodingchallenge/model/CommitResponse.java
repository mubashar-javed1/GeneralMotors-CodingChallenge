package com.mubashar.generalmotorcodingchallenge.model;

import com.google.gson.annotations.SerializedName;

public class CommitResponse{
    @SerializedName("sha")
    private String sha;
    @SerializedName("commit")
    private Commit commit;

    public CommitResponse () {
        // default constructor
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}

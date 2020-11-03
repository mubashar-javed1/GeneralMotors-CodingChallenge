package com.mubashar.generalmotorcodingchallenge.repository;


import com.mubashar.generalmotorcodingchallenge.network.ApiCall;

import java.util.List;

import io.reactivex.Observable;


public class RepositoryImp implements Repository {
    private ApiCall apiCall;

    public RepositoryImp(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    @Override
    public Observable<List<String>> getAllCommits() {
        return apiCall.getCommits();
    }
}

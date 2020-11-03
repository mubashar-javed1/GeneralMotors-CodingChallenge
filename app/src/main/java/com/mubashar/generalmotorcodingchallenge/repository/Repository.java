package com.mubashar.generalmotorcodingchallenge.repository;



import com.mubashar.generalmotorcodingchallenge.model.CommitResponse;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {
    Observable<List<CommitResponse>> getAllCommits();
}
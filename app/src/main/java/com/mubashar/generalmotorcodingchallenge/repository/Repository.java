package com.mubashar.generalmotorcodingchallenge.repository;



import java.util.List;

import io.reactivex.Observable;

public interface Repository {
    Observable<List<String>> getAllCommits();
}
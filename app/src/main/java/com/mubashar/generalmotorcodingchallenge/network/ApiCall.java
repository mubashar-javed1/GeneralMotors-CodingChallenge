package com.mubashar.generalmotorcodingchallenge.network;


import com.mubashar.generalmotorcodingchallenge.model.CommitResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiCall {
    @GET(ApiConfig.GET_COMMITS)
    Observable<List<CommitResponse>> getCommits();
}
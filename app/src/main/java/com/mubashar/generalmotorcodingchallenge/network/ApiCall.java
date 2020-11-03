package com.example.generalmotors.network;


import com.example.generalmotors.model.CommitResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiCall {
    @GET(ApiConfig.GET_COMMITS)
    Observable<List<CommitResponse>> getCommits();
}
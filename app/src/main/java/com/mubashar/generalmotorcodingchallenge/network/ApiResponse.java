package com.mubashar.generalmotorcodingchallenge.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mubashar.generalmotorcodingchallenge.model.CommitResponse;

import java.util.List;

import static com.mubashar.generalmotorcodingchallenge.network.Status.ERROR;
import static com.mubashar.generalmotorcodingchallenge.network.Status.LOADING;
import static com.mubashar.generalmotorcodingchallenge.network.Status.SUCCESS;


public class ApiResponse {

    public final Status status;

    @Nullable
    public final List<CommitResponse> data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable List<CommitResponse> data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull List<CommitResponse> data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse responseError(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }
}
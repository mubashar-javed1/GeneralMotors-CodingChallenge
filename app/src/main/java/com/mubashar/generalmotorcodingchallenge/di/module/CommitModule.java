package com.mubashar.generalmotorcodingchallenge.di.module;


import com.mubashar.generalmotorcodingchallenge.network.ApiCall;
import com.mubashar.generalmotorcodingchallenge.repository.Repository;
import com.mubashar.generalmotorcodingchallenge.repository.RepositoryImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class CommitModule {
    @Provides
    @Singleton
    ApiCall getApiCallInterface(Retrofit retrofit) {
        return retrofit.create(ApiCall.class);
    }

    @Provides
    @Singleton
    Repository getRepository(ApiCall apiCallInterface) {
        return new RepositoryImp(apiCallInterface);
    }
}
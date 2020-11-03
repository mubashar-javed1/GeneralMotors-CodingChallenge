package com.example.generalmotors.di.module;

import com.example.generalmotors.network.ApiCall;
import com.example.generalmotors.repository.Repository;
import com.example.generalmotors.repository.RepositoryImp;

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
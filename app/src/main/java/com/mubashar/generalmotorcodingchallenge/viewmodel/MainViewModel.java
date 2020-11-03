package com.mubashar.generalmotorcodingchallenge.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.mubashar.generalmotorcodingchallenge.di.scope.MainActivityScope;
import com.mubashar.generalmotorcodingchallenge.network.ApiResponse;
import com.mubashar.generalmotorcodingchallenge.repository.Repository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@MainActivityScope
public class MainViewModel extends ViewModel {
    Repository repository;

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<ApiResponse> responseLiveData = new MutableLiveData<>();

    @Inject
    MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getAllCommits() {
        disposables.add(repository.getAllCommits()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> responseLiveData.setValue(ApiResponse.loading()))
                .subscribe(
                        result -> responseLiveData.setValue(ApiResponse.success(result)),
                        throwable -> responseLiveData.setValue(ApiResponse.responseError(throwable))
                ));
    }

    public MutableLiveData<ApiResponse> getResponseLiveData() {
        return responseLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
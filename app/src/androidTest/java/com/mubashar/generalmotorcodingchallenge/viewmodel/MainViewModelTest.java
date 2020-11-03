package com.mubashar.generalmotorcodingchallenge.viewmodel;

import com.mubashar.generalmotorcodingchallenge.model.CommitResponse;
import com.mubashar.generalmotorcodingchallenge.repository.RepositoryImp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;


@RunWith(MockitoJUnitRunner.class)
public class MainViewModelTest {
    @Mock
    RepositoryImp repository;
    @InjectMocks
    MainViewModel mainViewModel = new MainViewModel(repository);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        List<CommitResponse> responses = Arrays.asList(new CommitResponse());
        Observable<List<CommitResponse>> observable = Observable.create(observer -> {
            observer.onNext(responses);
            observer.onComplete();
        });
        Mockito.when(repository.getAllCommits()).thenReturn(observable);
    }

    @Test
    public void getAllCommitsTest() {
        mainViewModel.getAllCommits();
        Mockito.verify(repository).getAllCommits();
    }

    @After
    public void tearDown() throws Exception {
    }
}
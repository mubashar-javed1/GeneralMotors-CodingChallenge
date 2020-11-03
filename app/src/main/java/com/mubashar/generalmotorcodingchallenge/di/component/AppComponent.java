package com.mubashar.generalmotorcodingchallenge.di.component;


import com.mubashar.generalmotorcodingchallenge.di.module.CommitModule;
import com.mubashar.generalmotorcodingchallenge.di.module.MainActivityModule;
import com.mubashar.generalmotorcodingchallenge.di.module.RetrofitModule;
import com.mubashar.generalmotorcodingchallenge.di.subcomponent.MainActivitySubComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        MainActivityModule.class,
        RetrofitModule.class,
        CommitModule.class
})
public interface AppComponent {
    MainActivitySubComponent.Factory mainActivityComponent();
}

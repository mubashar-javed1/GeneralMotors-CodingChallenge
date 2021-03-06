package com.mubashar.generalmotorcodingchallenge.di;
import android.app.Application;

import com.mubashar.generalmotorcodingchallenge.di.component.AppComponent;
import com.mubashar.generalmotorcodingchallenge.di.component.DaggerAppComponent;
import com.mubashar.generalmotorcodingchallenge.di.module.RetrofitModule;

/*
* Main application
* */
public class GMApplication extends Application {
    AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().retrofitModule(new RetrofitModule(this)).build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
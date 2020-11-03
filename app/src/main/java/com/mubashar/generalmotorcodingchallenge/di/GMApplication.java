package com.mubashar.generalmotorcodingchallenge.di;
import android.app.Application;

import com.mubashar.generalmotorcodingchallenge.di.component.AppComponent;
import com.mubashar.generalmotorcodingchallenge.di.component.DaggerAppComponent;


public class GMApplication extends Application {
    AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }

    public AppComponent getComponent() {
        return component;
    }
}
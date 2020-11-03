package com.mubashar.generalmotorcodingchallenge.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mubashar.generalmotorcodingchallenge.R;
import com.mubashar.generalmotorcodingchallenge.di.GMApplication;
import com.mubashar.generalmotorcodingchallenge.di.subcomponent.MainActivitySubComponent;

public class MainActivity extends AppCompatActivity {

    private MainActivitySubComponent component;

    public MainActivitySubComponent getComponent() {
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component = ((GMApplication)getApplication()).getComponent().mainActivityComponent().create();
        component.inject(this);
    }
}
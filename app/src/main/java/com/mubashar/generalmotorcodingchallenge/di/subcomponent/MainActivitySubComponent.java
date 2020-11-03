package com.mubashar.generalmotorcodingchallenge.di.subcomponent;

import com.mubashar.generalmotorcodingchallenge.di.scope.MainActivityScope;
import com.mubashar.generalmotorcodingchallenge.ui.activities.MainActivity;
import com.mubashar.generalmotorcodingchallenge.ui.fragments.MainFragment;

import dagger.Subcomponent;

@MainActivityScope
@Subcomponent
public interface MainActivitySubComponent {
    @Subcomponent.Factory
    interface Factory {
        MainActivitySubComponent create();
    }

    // MainActivity, MainFragment
    // request injection from MainActivitySubComponent. The graph needs to satisfy
    // all the dependencies of the fields those classes are injecting
    void inject(MainActivity loginActivity);
    void inject(MainFragment mainFragment);
}
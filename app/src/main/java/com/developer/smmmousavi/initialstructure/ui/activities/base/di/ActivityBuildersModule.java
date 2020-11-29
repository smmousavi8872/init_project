package com.developer.smmmousavi.initialstructure.ui.activities.base.di;

import com.developer.smmmousavi.initialstructure.ui.activities.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

}

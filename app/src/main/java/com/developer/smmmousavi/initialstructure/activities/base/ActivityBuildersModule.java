package com.developer.smmmousavi.initialstructure.activities.base;

import com.developer.smmmousavi.initialstructure.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}

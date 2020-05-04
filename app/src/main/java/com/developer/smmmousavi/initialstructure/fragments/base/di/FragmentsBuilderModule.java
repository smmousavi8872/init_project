package com.developer.smmmousavi.initialstructure.fragments.base.di;

import com.developer.smmmousavi.initialstructure.fragments.base.BaseDaggerFrgment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector(modules = {BaseFragmentModule.class, BaseFragmentVMModule.class,})
    abstract BaseDaggerFrgment contributeBaseDaggerFragment();

}

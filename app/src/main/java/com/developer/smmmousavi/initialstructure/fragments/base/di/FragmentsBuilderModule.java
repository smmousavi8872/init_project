package com.developer.smmmousavi.initialstructure.fragments.base.di;

import com.developer.smmmousavi.initialstructure.fragments.base.BaseDaggerFrgment;
import com.developer.smmmousavi.initialstructure.fragments.main.MainDaggerFragment;
import com.developer.smmmousavi.initialstructure.fragments.main.di.MainDaggerFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector(modules = {BaseFragmentModule.class, BaseFragmentVMModule.class,})
    abstract BaseDaggerFrgment contributeBaseDaggerFragment();

    @ContributesAndroidInjector(modules = {MainDaggerFragmentModule.class, BaseFragmentVMModule.class,})
    abstract MainDaggerFragment contributeMainDaggerFragment();

}

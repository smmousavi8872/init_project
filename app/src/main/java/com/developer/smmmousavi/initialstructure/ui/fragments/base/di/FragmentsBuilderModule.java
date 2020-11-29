package com.developer.smmmousavi.initialstructure.ui.fragments.base.di;

import com.developer.smmmousavi.initialstructure.ui.fragments.base.BaseDaggerFrgment;
import com.developer.smmmousavi.initialstructure.ui.fragments.main.MainDaggerFragment;
import com.developer.smmmousavi.initialstructure.ui.fragments.main.di.MainDaggerFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector(modules = {BaseFragmentModule.class, BaseFragmentVMModule.class,})
    abstract BaseDaggerFrgment contributeBaseDaggerFragment();

    @ContributesAndroidInjector(modules = {MainDaggerFragmentModule.class, BaseFragmentVMModule.class,})
    abstract MainDaggerFragment contributeMainDaggerFragment();

}

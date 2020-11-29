package com.developer.smmmousavi.initialstructure.ui.fragments.main.di;

import com.developer.smmmousavi.initialstructure.factory.viewmodel.di.ViewModelKey;
import com.developer.smmmousavi.initialstructure.ui.fragments.main.MainDaggerFragmentViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MianDaggerFragmentVMModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainDaggerFragmentViewModel.class)
    public abstract MainDaggerFragmentViewModel bindMainDaggerFragmentViewModel(MainDaggerFragmentViewModel mainDaggerFragmentViewModel);
}

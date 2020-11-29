package com.developer.smmmousavi.initialstructure.ui.fragments.main;

import android.app.Application;

import com.developer.smmmousavi.initialstructure.base.BaseViewModel;

import javax.inject.Inject;

public class MainDaggerFragmentViewModel extends BaseViewModel {

    @Inject
    public MainDaggerFragmentViewModel(Application app) {
        super(app);
    }
}

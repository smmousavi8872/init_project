package com.developer.smmmousavi.initialstructure.ui.fragments.base;

import android.app.Application;

import com.developer.smmmousavi.initialstructure.base.BaseViewModel;

import javax.inject.Inject;

public class BaseFragmentViewModel extends BaseViewModel {

    @Inject
    public BaseFragmentViewModel(Application app) {
        super(app);
    }
}

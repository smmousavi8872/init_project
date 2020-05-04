package com.developer.smmmousavi.initialstructure.fragments.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.smmmousavi.initialstructure.R;
import com.developer.smmmousavi.initialstructure.factory.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseDaggerFrgment extends DaggerFragment {

    public BaseDaggerFrgment() {
        // Required empty public constructor
    }

    private BaseFragmentViewModel mViewModel;
    private FragmentManager mFm;

    @Inject
    ViewModelProviderFactory mProviderFactory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_base_dagger, container, false);

        initVariables();

        return v;
    }

    private void initVariables() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(BaseFragmentViewModel.class);
        mFm = getFragmentManager();
    }

    public void replaceFragment(@IdRes int containerId,
                                @NonNull Fragment fragment,
                                @NonNull String tag,
                                @AnimatorRes @AnimRes int enterAnimId,
                                @AnimatorRes @AnimRes int exitAnimId) {

        Fragment foundFragment = mFm.findFragmentByTag(tag);
        if (foundFragment == null)
            mFm.beginTransaction()
                .setCustomAnimations(enterAnimId, exitAnimId)
                .replace(containerId, fragment, tag)
                .addToBackStack(tag)
                .commit();
        else
            mFm.beginTransaction()
                .setCustomAnimations(enterAnimId, exitAnimId)
                .replace(containerId, fragment, tag)
                .commit();

    }

    public void removeFragment(@NonNull Fragment fragment) {
        mFm.beginTransaction()
            .remove(fragment)
            .commit();
    }

    public Fragment findFragmentByTag(String fragmentTag) {
        return mFm.findFragmentByTag(fragmentTag);
    }

}

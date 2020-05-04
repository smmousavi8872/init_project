package com.developer.smmmousavi.initialstructure.fragments.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.smmmousavi.initialstructure.R;
import com.developer.smmmousavi.initialstructure.factory.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainDaggerFragment extends Fragment {

    public static final String TAG = "MainDaggerFragmentTag";

    public MainDaggerFragment() {
        // Required empty public constructor
    }

    private MainDaggerFragmentViewModel mViewModel;

    @Inject
    ViewModelProviderFactory mProviderFactory;

    public static MainDaggerFragment newInstance() {

        Bundle args = new Bundle();

        MainDaggerFragment fragment = new MainDaggerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_main_dagger, container, false);
        return v;
    }

    private void initVariables() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(MainDaggerFragmentViewModel.class);

    }
}

package com.developer.smmmousavi.initialstructure.activities.main;

import com.developer.smmmousavi.initialstructure.activities.singlefragment.SingleFragmentActivity;
import com.developer.smmmousavi.initialstructure.fragments.main.MainDaggerFragment;

import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return MainDaggerFragment.newInstance();
    }

    @Override
    public String getTag() {
        return MainDaggerFragment.TAG;
    }
}

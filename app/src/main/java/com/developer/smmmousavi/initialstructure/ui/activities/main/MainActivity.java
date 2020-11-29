package com.developer.smmmousavi.initialstructure.ui.activities.main;

import com.developer.smmmousavi.initialstructure.ui.activities.singlefragment.SingleFragmentActivity;
import com.developer.smmmousavi.initialstructure.ui.fragments.main.MainDaggerFragment;

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

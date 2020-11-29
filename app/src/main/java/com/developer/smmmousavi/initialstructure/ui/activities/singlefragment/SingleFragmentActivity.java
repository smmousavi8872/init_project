package com.developer.smmmousavi.initialstructure.ui.activities.singlefragment;

import android.os.Bundle;

import com.developer.smmmousavi.initialstructure.R;
import com.developer.smmmousavi.initialstructure.ui.activities.base.BaseDaggerCompatActivity;
import com.developer.smmmousavi.initialstructure.factory.SingleFragmentFactory;

import androidx.fragment.app.Fragment;


public abstract class SingleFragmentActivity extends BaseDaggerCompatActivity implements SingleFragmentFactory {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        /*
         * Factory Method Design Pattern
         * Functionality: Client
         */
        insertFragment();
    }

    private void insertFragment() {
        Fragment foundFragment = mFm.findFragmentById(R.id.flSingleFragmentContainer);

        if (foundFragment == null) {
            foundFragment = createFragment();
            String tag = getTag();
            mFm.beginTransaction()
                .add(R.id.flSingleFragmentContainer, foundFragment, tag)
                .commit();
        }
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}

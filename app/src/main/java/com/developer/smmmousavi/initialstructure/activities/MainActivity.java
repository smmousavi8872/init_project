package com.developer.smmmousavi.initialstructure.activities;

import android.os.Bundle;

import com.developer.smmmousavi.initialstructure.R;
import com.developer.smmmousavi.initialstructure.activities.base.BaseDaggerCompatActivity;

public class MainActivity extends BaseDaggerCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

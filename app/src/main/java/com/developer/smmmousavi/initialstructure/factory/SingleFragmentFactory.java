package com.developer.smmmousavi.initialstructure.factory;

import androidx.fragment.app.Fragment;

public interface SingleFragmentFactory {

   /*
    * Factory Method Design Pattern
    * Functionality: Factory methods which return products
    */

   Fragment createFragment();

   String getTag();
}

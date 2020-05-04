package com.developer.smmmousavi.initialstructure.application.di;

import android.app.Application;

import com.developer.smmmousavi.initialstructure.activities.base.ActivityBuildersModule;
import com.developer.smmmousavi.initialstructure.application.BaseApplication;
import com.developer.smmmousavi.initialstructure.factory.viewmodel.di.ViewModelFactoryModule;
import com.developer.smmmousavi.initialstructure.fragments.base.di.FragmentsBuilderModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
    AndroidSupportInjectionModule.class,
    BaseApplicationModule.class,
    ActivityBuildersModule.class,
    FragmentsBuilderModule.class,
    ViewModelFactoryModule.class
})

public interface ApplicationComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}

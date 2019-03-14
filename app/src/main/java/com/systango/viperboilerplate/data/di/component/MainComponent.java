package com.systango.viperboilerplate.data.di.component;

import android.content.Context;

import com.systango.viperboilerplate.ViperApplication;
import com.systango.viperboilerplate.data.datastore.RemoteMovieDataStore;
import com.systango.viperboilerplate.data.di.ApplicationContext;
import com.systango.viperboilerplate.data.di.ApplicationScope;
import com.systango.viperboilerplate.data.di.module.AppModule;
import com.systango.viperboilerplate.data.di.module.NetworkModule;
import com.systango.viperboilerplate.data.network.ApiCallInterface;

import dagger.Component;

/**
 * Created by Mohit Rajput on 13/3/19.
 * TODO: Insert javadoc information here
 */

@ApplicationScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface MainComponent {
    @ApplicationContext
    Context getContext();

    ApiCallInterface getApiInterface();

//    PopularSubComponent plus(PopularMovieModule popularMovieModule);

    void injectApplication(ViperApplication viperApplication);

    void injectApplication(RemoteMovieDataStore remoteMovieDataStore);
}

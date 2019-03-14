package com.systango.viperboilerplate.data.di.popular;

import android.content.Context;

import com.systango.viperboilerplate.data.datastore.LocalMovieDataStore;
import com.systango.viperboilerplate.data.datastore.RemoteMovieDataStore;
import com.systango.viperboilerplate.data.repository.MovieRepository;
import com.systango.viperboilerplate.domain.interactor.impl.GetPopularMovies;
import com.systango.viperboilerplate.presentation.presenter.MoviesPresenter;
import com.systango.viperboilerplate.presentation.presenter.MoviesPresenterImpl;
import com.systango.viperboilerplate.presentation.router.MoviesRouter;
import com.systango.viperboilerplate.presentation.router.impl.MoviesRouterImpl;
import com.systango.viperboilerplate.presentation.view.MoviesView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohit Rajput on 14/3/19.
 * TODO: Insert javadoc information here
 */
@Module
public class MovieListActivityMvpModule {
    private final MoviesView moviesView;

    public MovieListActivityMvpModule(MoviesView moviesView) {
        this.moviesView = moviesView;
    }

    @Provides
    @PopularScope
    MoviesView provideView() {
        return moviesView;
    }

    @Provides
    @PopularScope
    MoviesPresenter provideMoviePresenter(MoviesView moviesView) {
        return new MoviesPresenterImpl(moviesView);
    }

    @Provides
    @PopularScope
    MovieRepository provideMovieRepository(RemoteMovieDataStore remoteMovieDataStore, LocalMovieDataStore localMovieDataStore) {
        return new MovieRepository(remoteMovieDataStore, localMovieDataStore);
    }
}

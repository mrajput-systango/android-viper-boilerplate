package com.systango.viperboilerplate.domain.interactor.impl;

import com.systango.viperboilerplate.data.datastore.LocalMovieDataStore;
import com.systango.viperboilerplate.data.datastore.RemoteMovieDataStore;
import com.systango.viperboilerplate.data.repository.MovieRepository;
import com.systango.viperboilerplate.domain.entity.MovieEntity;
import com.systango.viperboilerplate.domain.interactor.AbstractInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 12/3/19.
 * TODO: Insert javadoc information here
 */
public class GetPopularMovies extends AbstractInteractor {

    private final MovieRepository movieRepository;

    public GetPopularMovies() {
        this.movieRepository = new MovieRepository(new RemoteMovieDataStore(), new LocalMovieDataStore());
    }

    public Observable<List<MovieEntity>> getPopularMovies() {
        return movieRepository.getPopularMovies();
    }
}

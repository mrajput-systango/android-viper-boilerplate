package com.systango.viperboilerplate.presentation.presenter;

import com.systango.viperboilerplate.presentation.entity.Movie;

/**
 * Created by Mohit Rajput on 13/3/19.
 * TODO: Insert javadoc information here
 */
public interface MoviesPresenter {
    void fetchPopularMovies();

    void onMovieItemClicked(Movie movie);
}

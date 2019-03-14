package com.systango.viperboilerplate.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.systango.viperboilerplate.R;
import com.systango.viperboilerplate.ViperApplication;
import com.systango.viperboilerplate.data.di.component.MainComponent;
import com.systango.viperboilerplate.data.di.popular.DaggerPopularSubComponent;
import com.systango.viperboilerplate.data.di.popular.MovieListActivityMvpModule;
import com.systango.viperboilerplate.data.di.popular.PopularSubComponent;
import com.systango.viperboilerplate.presentation.base.BaseActivity;
import com.systango.viperboilerplate.presentation.common.ToastUtils;
import com.systango.viperboilerplate.presentation.entity.Movie;
import com.systango.viperboilerplate.presentation.listener.OnMovieItemClickedListener;
import com.systango.viperboilerplate.presentation.presenter.MoviesPresenter;
import com.systango.viperboilerplate.presentation.ui.adapter.MovieAdapter;
import com.systango.viperboilerplate.presentation.view.MoviesView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListActivity extends BaseActivity implements MoviesView, OnMovieItemClickedListener {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    @Inject
    MoviesPresenter moviesPresenter;
    private MovieAdapter movieAdapter;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainComponent mainComponent = ViperApplication.getApp().getMainComponent();
        PopularSubComponent mainActivityComponent = DaggerPopularSubComponent.builder()
                .movieListActivityMvpModule(new MovieListActivityMvpModule(this))
                .mainComponent(mainComponent)
                .build();
        mainActivityComponent.inject(this);
        setContentView(R.layout.activity_movie_list);
        ButterKnife.bind(this);
        init();
        moviesPresenter.fetchPopularMovies();
    }

    private void init() {
        movies = new ArrayList<>();
        movieAdapter = new MovieAdapter(this, movies);
        movieAdapter.setOnMovieItemClickedListener(this);
        rvMovies.setAdapter(movieAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void showMovieList(List<Movie> movies) {
        refreshMovies(movies);
    }

    @Override
    public void showProgress() {
        ToastUtils.showShortToast(context, getString(R.string.loading_movies));
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String errorMessage) {
        ToastUtils.showLongToast(context, errorMessage);
    }

    @Override
    public void onMovieItemClicked(Movie movie) {
        moviesPresenter.onMovieItemClicked(movie);
    }

    private void refreshMovies(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        movieAdapter.notifyDataSetChanged();
    }
}
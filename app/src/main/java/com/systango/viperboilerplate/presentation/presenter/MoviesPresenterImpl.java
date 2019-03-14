package com.systango.viperboilerplate.presentation.presenter;

import android.app.Activity;
import android.util.Log;

import com.systango.viperboilerplate.domain.interactor.impl.GetPopularMovies;
import com.systango.viperboilerplate.presentation.base.BasePresenter;
import com.systango.viperboilerplate.presentation.entity.Movie;
import com.systango.viperboilerplate.presentation.mapper.MovieEntityMovieMapper;
import com.systango.viperboilerplate.presentation.router.MoviesRouter;
import com.systango.viperboilerplate.presentation.router.impl.MoviesRouterImpl;
import com.systango.viperboilerplate.presentation.view.MoviesView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mohit Rajput on 13/3/19.
 * TODO: Insert javadoc information here
 */
public class MoviesPresenterImpl extends BasePresenter<MoviesView> implements MoviesPresenter {
    private GetPopularMovies getPopularMovies;
    private MoviesRouter moviesRouter;
    private MovieEntityMovieMapper movieEntityMovieMapper = new MovieEntityMovieMapper();

    @Inject
    public MoviesPresenterImpl(MoviesView view) {
        super(view);
        moviesRouter = new MoviesRouterImpl((Activity) view);
        getPopularMovies = new GetPopularMovies();
    }

    @Override
    public void fetchPopularMovies() {
        addDisposable(getPopularMovies.getPopularMovies().map(results -> movieEntityMovieMapper.mapFrom(results))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> view.showProgress())
                .subscribe(
                        view::showMovieList,
                        throwable -> view.showError(throwable.getMessage())));
    }

    @Override
    public void onMovieItemClicked(Movie movie) {
        Log.d("Testing","movie="+movie);
        moviesRouter.goToMovieDetails(movie);
    }
}

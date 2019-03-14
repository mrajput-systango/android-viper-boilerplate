package com.systango.viperboilerplate.presentation.mapper;

import com.systango.viperboilerplate.common.Mapper;
import com.systango.viperboilerplate.domain.entity.MovieEntity;
import com.systango.viperboilerplate.presentation.entity.Movie;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mohit Rajput on 13/3/19.
 * TODO: Insert javadoc information here
 */
public class MovieEntityMovieMapper extends Mapper<MovieEntity, Movie> {
    private final static String posterBaseUrl = "https://image.tmdb.org/t/p/w342";
    private final static String backdropBaseUrl = "https://image.tmdb.org/t/p/w780";
    private final static String youTubeBaseUrl = "https://www.youtube.com/watch?v=";

    @Override
    public Movie mapFrom(MovieEntity from) {
        Movie movie = new Movie();
        movie.setId(from.getId());
        movie.setVoteCount(from.getVoteCount());
        movie.setVoteAverage(from.getVoteAverage());
        movie.setPopularity(from.getPopularity());
        movie.setAdult(from.getAdult());
        movie.setTitle(from.getTitle());
        movie.setPosterPath(posterBaseUrl + from.getPosterPath());
        movie.setOriginalLanguage(from.getOriginalLanguage());
        movie.setBackdropPath(from.getBackdropPath());
        movie.setOriginalTitle(from.getOriginalTitle());
        movie.setReleaseDate(from.getReleaseDate());
        movie.setOverview(from.getOverview());
        return movie;
    }

    public List<Movie> mapFrom(List<MovieEntity> from) {
        List<Movie> movieList = from.stream()
                .map(movieEntity -> mapFrom(movieEntity))
                .collect(Collectors.toList());
        return movieList;
    }
}

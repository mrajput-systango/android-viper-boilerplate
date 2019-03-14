package com.systango.viperboilerplate.data.mapper;

import com.systango.viperboilerplate.common.Mapper;
import com.systango.viperboilerplate.data.entity.MovieData;
import com.systango.viperboilerplate.domain.entity.MovieEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mohit Rajput on 13/3/19.
 * MovieData to MovieEntity DTO mapper
 */
public class MovieDataEntityMapper extends Mapper<MovieData, MovieEntity> {

    @Override
    public MovieEntity mapFrom(MovieData from) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(from.getId());
        movieEntity.setVoteCount(from.getVoteCount());
        movieEntity.setVoteAverage(from.getVoteAverage());
        movieEntity.setPopularity(from.getPopularity());
        movieEntity.setAdult(from.getAdult());
        movieEntity.setTitle(from.getTitle());
        movieEntity.setPosterPath(from.getPosterPath());
        movieEntity.setOriginalLanguage(from.getOriginalLanguage());
        movieEntity.setBackdropPath(from.getBackdropPath());
        movieEntity.setOriginalTitle(from.getOriginalTitle());
        movieEntity.setReleaseDate(from.getReleaseDate());
        movieEntity.setOverview(from.getOverview());
        return movieEntity;
    }

    public List<MovieEntity> mapFrom(List<MovieData> from) {
        List<MovieEntity> movieEntityList = from.stream()
                .map(movieData -> mapFrom(movieData))
                .collect(Collectors.toList());
        return movieEntityList;
    }
}

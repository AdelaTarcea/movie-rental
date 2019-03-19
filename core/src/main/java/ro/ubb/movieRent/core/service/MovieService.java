package ro.ubb.movieRent.core.service;

import ro.ubb.movieRent.core.domain.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

    Movie updateMovie(Long id,String name ,int year,int price);

    void deleteById(Long bookId);
}

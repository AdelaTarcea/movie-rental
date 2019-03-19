package ro.ubb.movieRent.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movieRent.core.domain.Movie;
import ro.ubb.movieRent.core.service.MovieService;
import ro.ubb.movieRent.web.converter.MovieConverter;
import ro.ubb.movieRent.web.dto.MovieDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private static final Logger log =
            LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;


    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    List<MovieDto> getMovies() {
        log.trace("getMovies --- method entered");

        List<Movie> movies = movieService.getAllMovies();
        log.trace("getMovies: movies={}", movies);

        return new ArrayList<>(movieConverter.convertModelsToDtos(movies));

    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    MovieDto saveMovie(@RequestBody final MovieDto dto) {
        log.trace("saveMovie: dto={}", dto);

        Movie movie = movieService.saveMovie(movieConverter.convertDtoToModel(dto));
        MovieDto result = movieConverter.convertModelToDto(movie);

        log.trace("saveMovie: result={}", result);

        return result;
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.PUT)
    MovieDto updateMovie(@PathVariable Long movieId,
                         @RequestBody MovieDto dto) {
        log.trace("updateMovie: movieId={}, movieDtoMap={}", movieId,
                dto);

        Movie movie = movieService.updateMovie(movieId,
                dto.getName(),
                dto.getPrice(),
                dto.getYear());

        MovieDto result = movieConverter.convertModelToDto(movie);

        log.trace("updateMovie: result={}", result);

        return result;
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteMovie(@PathVariable Long movieId) {
        log.trace("deleteMovie: movieId={}", movieId);

        movieService.deleteById(movieId);

        log.trace("deleteMovie --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}


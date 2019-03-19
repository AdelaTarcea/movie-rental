package ro.ubb.movieRent.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movieRent.core.domain.Movie;
import ro.ubb.movieRent.core.repository.MovieRepository;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService {
    private static final Logger log =
            LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        log.trace("getAllMovies --- method entered");

        List<Movie> result = movieRepository.findAll();

        log.trace("getAllMovies: result={}", result);

        return result;
    }

    @Override

    public Movie saveMovie(Movie movie) {
        log.trace("saveMovie: movie={}", movie);
        Movie result = movieRepository.save(movie);
        log.trace("saveMovie: result={}", result);
        return result;
    }

    @Override
    @Transactional
    public Movie updateMovie(Long id,String name ,int year,int price) {
        log.trace("updateMovie: name={}, year={}, price={}",
                name, year, price);

        Optional<Movie> movie = movieRepository.findById(id);

        movie.ifPresent(s -> {
            s.setName(name);
            s.setPrice(price);
            s.setYear(year);
        });

        log.trace("updateMovie: movie={}", movie.get());

        return movie.orElse(null);
    }

    @Override
    public void deleteById(Long movieId) {
        log.trace("deleteById: movieId={}", movieId);

        movieRepository.deleteById(movieId);

        log.trace("deleteById --- method finished");
    }
}


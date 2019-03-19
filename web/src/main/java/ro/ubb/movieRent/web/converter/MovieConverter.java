package ro.ubb.movieRent.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movieRent.core.domain.Movie;
import ro.ubb.movieRent.web.dto.MovieDto;

@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto> {
    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = new Movie(dto.getName(), dto.getYear(),  dto.getPrice());
        movie.setId(dto.getId());
        return movie;
    }

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto dto = new MovieDto(movie.getName(), movie.getYear(), movie.getPrice());
        dto.setId(movie.getId());
        return dto;
    }
}
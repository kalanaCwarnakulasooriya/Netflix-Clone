package lk.ijse.backend.service;

import lk.ijse.backend.dto.MovieDto;
import lk.ijse.backend.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {
    String addMovie(MovieDto movieDto);
    Page<Movie> getMovies(int page, int size);
    Movie getMovieById(String id);
    List<Movie> getMoviesByGenre(String genre);
    String updateMovie(String id, MovieDto movieDto);
    String deleteMovie(String id);
    Long getTotalViews();
    List<Movie> getMostViewedMovies();
}

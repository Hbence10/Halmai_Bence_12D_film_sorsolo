package Hbence.movieGeneratorAPI.dao;

import Hbence.movieGeneratorAPI.entity.Genre;
import Hbence.movieGeneratorAPI.entity.Movie;

import java.util.List;

public interface GeneratorDAO {
    List<Movie> getMovieByOneGenreAndAmount(int genreId, int amount);
    List<Genre> getAllGenre();
    Movie getSingleMovie(int id);
}

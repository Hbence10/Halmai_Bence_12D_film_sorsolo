package Hbence.movieGeneratorAPI.dao;

import Hbence.movieGeneratorAPI.entity.Genre;
import Hbence.movieGeneratorAPI.entity.Movie;

import java.util.List;

public interface GeneratorDAO {
    List<Movie> findMovieByGenreAndAmount(int genreId, int amount);
    List<Genre> getAllGenre();
}

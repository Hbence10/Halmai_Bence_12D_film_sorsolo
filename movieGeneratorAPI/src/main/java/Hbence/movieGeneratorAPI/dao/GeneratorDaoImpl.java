package Hbence.movieGeneratorAPI.dao;

import Hbence.movieGeneratorAPI.entity.Genre;
import Hbence.movieGeneratorAPI.entity.Movie;
import Hbence.movieGeneratorAPI.exceptions.TooManyMovies;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class GeneratorDaoImpl implements GeneratorDAO {

    public EntityManager entityManager;

    @Autowired
    public GeneratorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> getMovieByOneGenreAndAmount(int genreId, int amount) {
        Genre wantedGenre = entityManager.find(Genre.class, genreId);
        List<Movie> baseMovieList = wantedGenre.MoviesByRequest();
//        List<Movie> baseMovieList = new ArrayList<>();
        List<Movie> returnedMovieList = new ArrayList<Movie>();

        while (returnedMovieList.size() != amount){
            int randomIndex = new Random().nextInt(0, baseMovieList.size());

            if(!returnedMovieList.contains(baseMovieList.get(randomIndex))){
                returnedMovieList.add(baseMovieList.get(randomIndex));
            }
        }

        return returnedMovieList;
    }

    @Override
    public List<Genre> getAllGenre() {
        return entityManager.createQuery("from Genre", Genre.class).getResultList();
    }

    @Override
    public Movie getSingleMovie(int id) {
        return entityManager.find(Movie.class, id);
    }
}

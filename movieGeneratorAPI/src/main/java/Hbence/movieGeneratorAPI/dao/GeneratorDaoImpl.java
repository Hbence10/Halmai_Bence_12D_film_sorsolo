package Hbence.movieGeneratorAPI.dao;

import Hbence.movieGeneratorAPI.entity.Genre;
import Hbence.movieGeneratorAPI.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

        return wantedGenre.getMovies();
    }

    @Override
    public List<Genre> getAllGenre() {
        return entityManager.createQuery("from Genre", Genre.class).getResultList();
    }
}

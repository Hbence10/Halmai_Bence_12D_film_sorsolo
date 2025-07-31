package Hbence.movieGeneratorAPI.controller;

import Hbence.movieGeneratorAPI.dao.GeneratorDaoImpl;
import Hbence.movieGeneratorAPI.entity.Genre;
import Hbence.movieGeneratorAPI.entity.Movie;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/movie")
public class GeneratorController {
    public GeneratorDaoImpl movieDao;

    @Autowired
    public GeneratorController(GeneratorDaoImpl movieDao) {
        this.movieDao = movieDao;
    }

    //A moviekat visszaadja a kivant mufaj es mennyiseg alapjan
    @GetMapping("/movies")
    public List<Movie> getMovieByGenreAndAmount(@RequestParam("genre") int genre, @RequestParam("amount") int amount){
        return movieDao.findMovieByGenreAndAmount(genre, amount);
    }

    //Az osszes mufaj megszerzese
    @GetMapping("/genres")
    public List<Genre> getAllGenre(){
        return movieDao.getAllGenre();
    }
}

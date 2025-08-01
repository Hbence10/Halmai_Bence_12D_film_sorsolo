package Hbence.movieGeneratorAPI.controller;

import Hbence.movieGeneratorAPI.dao.GeneratorDaoImpl;
import Hbence.movieGeneratorAPI.entity.Genre;
import Hbence.movieGeneratorAPI.entity.Movie;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/movie")
public class GeneratorController {
    public GeneratorDaoImpl movieDao;

    @Autowired
    public GeneratorController(GeneratorDaoImpl movieDao) {
        this.movieDao = movieDao;
    }

    //Egy darab mufaj altal dob vissza kivant mennyisegu filmet
    @GetMapping("/movies")
    public List<Movie> getMovieByOneGenreAndAmount(@RequestParam("genre") int genre, @RequestParam("amount") int amount){
        return movieDao.getMovieByOneGenreAndAmount(genre, amount);
    }

    //Tobb darab mufaj altal dob vissza kivant mennyisegu filmet
    @GetMapping("/movies")
    public List<Movie> getMovieByMultipleGenreAndAmount(@RequestParam("genres") ArrayList<Integer> genres, @RequestParam("amount") int amount){
        return new ArrayList<>();
    }

    //Az osszes mufaj megszerzese
    @GetMapping("/genres")
    public List<Genre> getAllGenre(){
        return movieDao.getAllGenre();
    }

    //Film hozzaadasa --> Csak ADMIN csinalhassa
    @PostMapping("/movies")
    public String addMovie(@RequestParam("newMovie") Movie newMovie){
        return "";
    }
}

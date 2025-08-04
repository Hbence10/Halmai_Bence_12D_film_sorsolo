package Hbence.movieGeneratorAPI.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = {CascadeType.REMOVE})
    private List<Movie> movies;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Movie> getMovies() {
//        return movies;
//    }

//    public void setMovies(List<Movie> movies) {
//        this.movies = movies;
//    }

    public List<Movie> MoviesByRequest(){
        return this.movies;
    }

    @Override
    public String toString() {
        return "Genre{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

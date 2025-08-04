package Hbence.movieGeneratorAPI.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "length_in_minute")
    private int lengthInMinute;

    @Column(name = "rating")
    private String rating;

    @Column(name = "budget")
    private long budget;

    @Column(name = "description")
    private String description;

    @Column(name = "IMDB_rating")
    private float IMDBRating;

    @Column(name = "IMDB_link")
    private String IMDBlink;

    @Column(name = "trailer_link")
    private String trailerLink;

    @Column(name = "poster_path")
    private String posterPath;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    public Movie() {
    }

    public Movie(String title, int lengthInMinute, String rating, long budget, String description, float IMDBRating, String IMDBlink, String trailerLink, String posterPath) {
        this.title = title;
        this.lengthInMinute = lengthInMinute;
        this.rating = rating;
        this.budget = budget;
        this.description = description;
        this.IMDBRating = IMDBRating;
        this.IMDBlink = IMDBlink;
        this.trailerLink = trailerLink;
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthInMinute() {
        return lengthInMinute;
    }

    public void setLengthInMinute(int lengthInMinute) {
        this.lengthInMinute = lengthInMinute;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getIMDBRating() {
        return IMDBRating;
    }

    public void setIMDBRating(float IMDBRating) {
        this.IMDBRating = IMDBRating;
    }

    public String getIMDBlink() {
        return IMDBlink;
    }

    public void setIMDBlink(String IMDBlink) {
        this.IMDBlink = IMDBlink;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

//    public List<Genre> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(List<Genre> genres) {
//        this.genres = genres;
//    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title='" + title + '\'' + ", lengthInMinute=" + lengthInMinute + ", rating='" + rating + '\'' + ", budget=" + budget + ", description='" + description + '\'' + ", IMDBRating=" + IMDBRating + ", IMDBlink='" + IMDBlink + '\'' + ", trailerLink='" + trailerLink + '\'' + '}';
    }
}

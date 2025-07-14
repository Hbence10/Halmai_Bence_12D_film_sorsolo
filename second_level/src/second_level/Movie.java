package second_level;

public class Movie {

    private String title;
    private String[] directors;
    private Integer lengthInMinute;
    private String category;
    private String rating;
    private Integer budget;
    private Float imdbRating;

    public Movie(String title, String[] directors, Integer lengthInMinute, String category, String rating, Integer budget, Float imdbRating) {
        this.title = title;
        this.directors = directors;
        this.lengthInMinute = lengthInMinute;
        this.category = category;
        this.rating = rating;
        this.budget = budget;
        this.imdbRating = imdbRating;
    }

    public Integer getBudget() {
        return budget;
    }

    public String getCategory() {
        return category;
    }

    public String[] getDirectors() {
        return directors;
    }

    public Float getImdbRating() {
        return imdbRating;
    }

    public Integer getLengthInMinute() {
        return lengthInMinute;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setLengthInMinute(Integer lengthInMinute) {
        this.lengthInMinute = lengthInMinute;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "\tA film cime: " + this.getTitle() + ", IMDB ertekelese: " + getImdbRating().toString() + ", hossza percben: " + getLengthInMinute();
    }

}
package io.javabrains.moviecatalogservice.models;

public class Movie {
    private String movieId;
    private String movieName;

    //marshalling && unmarshalling
    //when java is converting something which is not object to object (such as restTemplate) => you need empty constructor
    //cause java first create an instance, then parse the string and populate it one by one
    public Movie(){}

    public Movie(String movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}

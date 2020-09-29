package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResources {
    @Autowired
    private RestTemplate restTemplate;

    //get apiKey from a configured values from property file
    @Value("${api.key}")
    private String apiKey;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
//        System.out.println("movie Resource");
//        return new Movie(movieId, "inception");

        //get info from movie db site:
        String xx=apiKey;
        String uu="https://api.themoviedb.org/3/movie/" +movieId +"?api_key="+apiKey;
        MovieSummary movieSummary = restTemplate
                .getForObject("https://api.themoviedb.org/3/movie/" +movieId +"?api_key="+apiKey,
                MovieSummary.class);
        return new Movie(movieId,movieSummary.getTitle());
    }
}

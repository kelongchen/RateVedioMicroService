package io.javabrains.ratingdataservice.resources;

import io.javabrains.ratingdataservice.models.Rating;
import io.javabrains.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResources {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        //IT IS NOT GOOD TO RETURN LIST IN API =>create a UserRating class that has 1 property of List
        // because in RestTemplate we can not get the class of it as 2nd parameter
        //we can use parameterizedType<List<Rating>>
        List<Rating> ratings = Arrays.asList(
                new Rating("movie1", 4),
                new Rating("movie2", 3)
        );
        return new UserRating(ratings);
    }
}

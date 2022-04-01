package com.manish.ratingsdataservice.restcontroller;


import com.manish.ratingsdataservice.model.Rating;
import com.manish.ratingsdataservice.model.UserRating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsDataController {

    @GetMapping("/{movieId}")
    public ResponseEntity<Rating> getMovieRating(@PathVariable String movieId){
        return new ResponseEntity<>(Rating.builder()
                .movieId(movieId)
                .rating(5)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserRating> getRatingByUser(@PathVariable("userId") String userId){
        List<Rating> ratings =  Arrays.asList(Rating.builder()
                        .movieId("1234")
                        .rating(4)
                        .build(),
                Rating.builder()
                        .movieId("1235")
                        .rating(4)
                        .build());

        UserRating userRating = UserRating.builder()
                .ratings(ratings)
                .build();

        return new ResponseEntity<UserRating>(userRating,HttpStatus.OK);

    }

}

package com.manish.moviecatalogservice.restcontroller;


import com.manish.moviecatalogservice.model.CatalogItem;
import com.manish.moviecatalogservice.model.Movie;
import com.manish.moviecatalogservice.model.Rating;
import com.manish.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movieCatalogs")
public class MovieCatalogController{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webclientBuilder;

    @GetMapping("/{userId}")
    public ResponseEntity<List<CatalogItem>> getCatalogsByUserId(@PathVariable String userId){
        List<Rating> ratings =restTemplate.getForEntity("http://ratings-data-service/ratings/users/"+userId, UserRating.class)
                .getBody()
                .getRatings();
        List<CatalogItem> catalogItems = ratings.stream().map(rating -> {
            
//           Movie movie = webclientBuilder.build()
//                   .get()
//                   .uri("http://localhost:8081/movieInfos/"+rating.getMovieId())
//                   .retrieve()
//                   .bodyToMono(Movie.class)
//                   .block();

           ResponseEntity<Movie> movieResponseEntity = restTemplate.getForEntity("http://movie-info-service/movieInfos/"+rating.getMovieId(),Movie.class);
           Movie movie = movieResponseEntity.getBody();
           return CatalogItem.builder()
                   .name(movie.getName())
                   .rating(rating.getRating())
                   .description(movie.getDescription())
                   .build();
        }).collect(Collectors.toList());
        return new ResponseEntity<>(catalogItems,HttpStatus.OK);
    }
}

package com.manish.movieinfoservice.restcontroller;

import com.manish.movieinfoservice.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieInfos")
public class MovieInfoController {

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieInfo(@PathVariable String movieId){
        return new ResponseEntity<>(Movie.builder()
                .name("test movie")
                .description("description")
                .movieId(movieId)
                .build(), HttpStatus.OK);
    }

}

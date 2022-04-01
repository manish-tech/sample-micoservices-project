package com.manish.movieinfoservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    private String movieId;
    private String name;
    private String description;
}

package com.manish.moviecatalogservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String movieId;
    private Integer rating;

}

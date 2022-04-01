package com.manish.ratingsdataservice.model;

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

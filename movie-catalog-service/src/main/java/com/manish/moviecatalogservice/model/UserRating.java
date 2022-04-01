package com.manish.moviecatalogservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRating {
    private List<Rating> ratings = new ArrayList<>();
}

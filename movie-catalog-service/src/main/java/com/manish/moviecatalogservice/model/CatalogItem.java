package com.manish.moviecatalogservice.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem {
    private String name;
    private String description;
    private Integer rating;

}

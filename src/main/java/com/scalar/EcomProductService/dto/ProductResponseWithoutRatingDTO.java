package com.scalar.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseWithoutRatingDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}


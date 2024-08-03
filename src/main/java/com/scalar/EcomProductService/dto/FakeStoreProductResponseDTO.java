package com.scalar.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
}

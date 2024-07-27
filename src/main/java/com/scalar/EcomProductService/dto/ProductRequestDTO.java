package com.scalar.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    //private int id;  -- 'id' should not be here, bcz UI will send all the details, id will be auto-incremental
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

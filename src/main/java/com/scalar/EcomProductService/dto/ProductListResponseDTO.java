package com.scalar.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ProductListResponseDTO {
    private List<ProductResponseDTO> productListResponseDTO;

    public ProductListResponseDTO () {
        this.productListResponseDTO = new ArrayList<>();
    }
}

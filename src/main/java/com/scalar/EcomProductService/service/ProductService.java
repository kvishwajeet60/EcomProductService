package com.scalar.EcomProductService.service;


import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductRequestDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseWithoutRatingDTO;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id);
    ProductResponseWithoutRatingDTO updateProduct(int id, ProductRequestDTO productRequestDTO);
    ProductResponseWithoutRatingDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO deleteProduct(int id);
}

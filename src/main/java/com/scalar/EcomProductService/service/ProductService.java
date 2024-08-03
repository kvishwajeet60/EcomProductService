package com.scalar.EcomProductService.service;


import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductRequestDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseWithoutRatingDTO;
import com.scalar.EcomProductService.exception.ProductNotFoundException;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO);
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO deleteProduct(int id) throws ProductNotFoundException;
}

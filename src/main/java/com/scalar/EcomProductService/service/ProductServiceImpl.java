package com.scalar.EcomProductService.service;

import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductRequestDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseWithoutRatingDTO;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements  ProductService {
    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    @Override
    public ProductResponseWithoutRatingDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public ProductResponseWithoutRatingDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public ProductResponseDTO deleteProduct(int id) {
        return null;
    }
}

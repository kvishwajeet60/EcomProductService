package com.scalar.EcomProductService.service;


import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.model.Product;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id);
    Product updateProduct(int id, Product updatedProduct);
    Product createProduct(Product product);
    Product deleteProduct(int id);
}

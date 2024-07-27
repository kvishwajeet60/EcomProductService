package com.scalar.EcomProductService.service;

import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        //calling 3rd party API
        String getAllProductsURL_3rdParty = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductListResponseDTO> productListResponseDTOResponseEntity
                = restTemplate.getForEntity(getAllProductsURL_3rdParty, ProductListResponseDTO.class);

        return productListResponseDTOResponseEntity.getBody();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        //calling 3rd party API
        String getProductByIdURL_3rdParty = "https://fakestoreapi.com/products/" +id    ;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.getForEntity(getProductByIdURL_3rdParty, ProductResponseDTO.class);

        return productResponseDTOResponseEntity.getBody();
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }
}

package com.scalar.EcomProductService.service;

import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        //calling 3rd party API
        String getAllProductsURL_3rdParty = "http://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductListResponseDTO> productListResponseDTOResponseEntity
                = restTemplate.getForEntity(getAllProductsURL_3rdParty, ProductListResponseDTO.class);

        return productListResponseDTOResponseEntity.getBody();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        //calling 3rd party API
        String getProductByIdURL_3rdParty = "http://fakestoreapi.com/products/" +id    ;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("Seeting HttpHeaders...###");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.getForEntity(getProductByIdURL_3rdParty, ProductResponseDTO.class);*/

        ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(getProductByIdURL_3rdParty, HttpMethod.GET, entity, ProductResponseDTO.class);

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

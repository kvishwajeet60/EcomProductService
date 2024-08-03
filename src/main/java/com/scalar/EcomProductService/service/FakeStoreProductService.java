package com.scalar.EcomProductService.service;

import com.scalar.EcomProductService.client.FakeStoreAPIClient;
import com.scalar.EcomProductService.dto.*;
import com.scalar.EcomProductService.exception.ProductNotFoundException;
import com.scalar.EcomProductService.utils.ProductUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.scalar.EcomProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scalar.EcomProductService.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = fakeStoreAPIClient.getAllProducts();

        ProductListResponseDTO responseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOList){
            ProductResponseDTO productResponseDTO = fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
            responseDTO.getProductListResponseDTO().add(productResponseDTO);
        }

        return responseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);

        if(ProductUtils.isNull(fakeStoreProductResponseDTO)){
            System.out.println("Getting Response as NULL.");
            throw new ProductNotFoundException("Product not found with id: "+id);
        }

        ProductResponseDTO productResponseDTO = fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);

        return productResponseDTO;
    }



    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        ProductResponseDTO productResponseDTO = fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO deleteProduct(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.deleteProduct(id);

        if(ProductUtils.isNull(fakeStoreProductResponseDTO)){
            throw new ProductNotFoundException("Product not found with id:"+id+ " which you are going to delete");
        }
        ProductResponseDTO productResponseDTO = fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.updateProduct(id, fakeStoreProductRequestDTO);

        ProductResponseDTO productResponseDTO = fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
        return productResponseDTO;
    }
}

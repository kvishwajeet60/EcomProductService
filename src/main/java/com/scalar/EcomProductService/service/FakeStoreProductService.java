package com.scalar.EcomProductService.service;

import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductRequestDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseWithoutRatingDTO;
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

        System.out.println("Seeting HttpHeaders... getAllProducts");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /*ResponseEntity<ProductResponseDTO[]> responseArray
                = restTemplate.getForEntity(getAllProductsURL_3rdParty, ProductResponseDTO[].class);*/

        ResponseEntity<ProductResponseDTO[]> responseArray
                = restTemplate.exchange(getAllProductsURL_3rdParty, HttpMethod.GET, entity, ProductResponseDTO[].class);


        ProductListResponseDTO responseDTO = new ProductListResponseDTO();
        for(ProductResponseDTO productResponseDTO : responseArray.getBody()){
            responseDTO.getProductListResponseDTO().add(productResponseDTO);
        }

        return responseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        //calling 3rd party API
        String getProductByIdURL_3rdParty = "http://fakestoreapi.com/products/" +id    ;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("Seeting HttpHeaders... getProductById");
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
    public ProductResponseWithoutRatingDTO createProduct(ProductRequestDTO productRequestDTO) {
        //calling 3rd party API
        String createProductURL_3rdParty = "http://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("Seeting HttpHeaders... createProduct ");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON); // Ensure content type is set to JSON
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        // Create HttpEntity with the request body and headers
        HttpEntity<ProductRequestDTO> entity = new HttpEntity<>(productRequestDTO, headers);

        ResponseEntity<ProductResponseWithoutRatingDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(createProductURL_3rdParty, HttpMethod.POST, entity, ProductResponseWithoutRatingDTO.class);


        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.postForEntity(createProductURL_3rdParty, productRequestDTO, ProductResponseDTO.class);*/
        return productResponseDTOResponseEntity.getBody();
    }

    @Override
    public ProductResponseDTO deleteProduct(int id) {
        //calling 3rd party API
        String deleteProductURL_3rdParty = "http://fakestoreapi.com/products/" +id    ;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("Seeting HttpHeaders... deleteProduct");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.getForEntity(getProductByIdURL_3rdParty, ProductResponseDTO.class);*/

        ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(deleteProductURL_3rdParty, HttpMethod.DELETE, entity, ProductResponseDTO.class);

        return productResponseDTOResponseEntity.getBody();
    }

    @Override
    public ProductResponseWithoutRatingDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {

        //calling 3rd party API
        String updateProductURL_3rdParty = "http://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("Seeting HttpHeaders...updateProduct");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON); // Ensure content type is set to JSON
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        // Create HttpEntity with the request body and headers
        HttpEntity<ProductRequestDTO> entity = new HttpEntity<>(productRequestDTO, headers);

        ResponseEntity<ProductResponseWithoutRatingDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(updateProductURL_3rdParty, HttpMethod.PUT, entity, ProductResponseWithoutRatingDTO.class);


        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.postForEntity(createProductURL_3rdParty, productRequestDTO, ProductResponseDTO.class);*/
        return productResponseDTOResponseEntity.getBody();
    }
}

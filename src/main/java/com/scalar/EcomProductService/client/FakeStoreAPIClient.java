package com.scalar.EcomProductService.client;

import com.scalar.EcomProductService.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Wrapper on FakeStoreProduct APIs
 */
@Component
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreApiURL;

    /* FILED INJECTION */
    @Value("${fakestore.api.path.product}")
    private String fakeStoreApiPathProduct;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
                              @Value("${fakestore.api.url}") String fakeStoreApiURL) {    /* CONSTRUCTOR INJECTION */
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreApiURL = fakeStoreApiURL;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        //calling 3rd party API
        String createProductURL_3rdParty = fakeStoreApiURL + fakeStoreApiPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("--> Setting HttpHeaders... createProduct in FakeStoreAPIClient...");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON); // Ensure content type is set to JSON
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        // Create HttpEntity with the request body and headers
        HttpEntity<FakeStoreProductRequestDTO> entity = new HttpEntity<>(fakeStoreProductRequestDTO, headers);

        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(createProductURL_3rdParty, HttpMethod.POST, entity, FakeStoreProductResponseDTO.class);


        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.postForEntity(createProductURL_3rdParty, productRequestDTO, ProductResponseDTO.class);*/
        return productResponseDTOResponseEntity.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        //calling 3rd party API
        String getProductByIdURL_3rdParty = fakeStoreApiURL + fakeStoreApiPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("--> Setting HttpHeaders... getProductById in FakeStoreAPIClient...");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.getForEntity(getProductByIdURL_3rdParty, ProductResponseDTO.class);*/

        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(getProductByIdURL_3rdParty, HttpMethod.GET, entity, FakeStoreProductResponseDTO.class);

        return productResponseDTOResponseEntity.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        //calling 3rd party API
        String getAllProductsURL_3rdParty = fakeStoreApiURL + fakeStoreApiPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("--> Setting HttpHeaders... getAllProducts in FakeStoreAPIClient...");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /*ResponseEntity<ProductResponseDTO[]> responseArray
                = restTemplate.getForEntity(getAllProductsURL_3rdParty, ProductResponseDTO[].class);*/

        ResponseEntity<FakeStoreProductResponseDTO[]> responseArray
                = restTemplate.exchange(getAllProductsURL_3rdParty, HttpMethod.GET, entity, FakeStoreProductResponseDTO[].class);

        //return List.of(responseArray.getBody());

        return Arrays.asList(responseArray.getBody());
    }

    public FakeStoreProductResponseDTO deleteProduct(int id) {
        //calling 3rd party API
        String deleteProductURL_3rdParty = fakeStoreApiURL + fakeStoreApiPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("--> Setting HttpHeaders... deleteProduct in FakeStoreAPIClient...");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.getForEntity(getProductByIdURL_3rdParty, ProductResponseDTO.class);*/

        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(deleteProductURL_3rdParty, HttpMethod.DELETE, entity, FakeStoreProductResponseDTO.class);

        return productResponseDTOResponseEntity.getBody();
    }

    public FakeStoreProductResponseDTO updateProduct(int id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {

        //calling 3rd party API
        String updateProductURL_3rdParty = fakeStoreApiURL + fakeStoreApiPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        System.out.println("--> Setting HttpHeaders...updateProduct in FakeStoreAPIClient...");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON); // Ensure content type is set to JSON
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        // Create HttpEntity with the request body and headers
        HttpEntity<FakeStoreProductRequestDTO> entity = new HttpEntity<>(fakeStoreProductRequestDTO, headers);

        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.exchange(updateProductURL_3rdParty, HttpMethod.PUT, entity, FakeStoreProductResponseDTO.class);


        /*ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity
                = restTemplate.postForEntity(createProductURL_3rdParty, productRequestDTO, ProductResponseDTO.class);*/
        return productResponseDTOResponseEntity.getBody();
    }
}

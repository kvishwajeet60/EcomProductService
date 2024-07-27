package com.scalar.EcomProductService.controller;

import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        /*ProductResponseDTO productResponseDTO_1 = new ProductResponseDTO();
        productResponseDTO_1.setId(1);
        productResponseDTO_1.setTitle("IPhone 15 pro");
        productResponseDTO_1.setPrice(150000);
        productResponseDTO_1.setDescription("Kafi Mehaga Phone");
        productResponseDTO_1.setCategory("Electronics");
        productResponseDTO_1.setImage("www.google.com/iphone15/");

        ProductResponseDTO productResponseDTO_2 = new ProductResponseDTO();
        productResponseDTO_2.setId(2);
        productResponseDTO_2.setTitle("Macbook pro");
        productResponseDTO_2.setPrice(250000);
        productResponseDTO_2.setDescription("Kafi Mehaga Laptop");
        productResponseDTO_2.setCategory("Electronics");
        productResponseDTO_2.setImage("www.google.com/macbookPro/");

        List<ProductResponseDTO> products =Arrays.asList(productResponseDTO_1,productResponseDTO_2);
        return ResponseEntity.ok(products); //it wraps actual response and http status code
         */
        ProductListResponseDTO productListResponseDTO = productService.getAllProducts();
        return ResponseEntity.ok(productListResponseDTO);
    }

    @GetMapping("/products/1")
    public ResponseEntity getProductFromId(){
        ProductResponseDTO productResponseDTO = productService.getProductById(1);

        return ResponseEntity.ok(productResponseDTO);
    }

}

package com.scalar.EcomProductService.controller;

import com.scalar.EcomProductService.dto.ProductListResponseDTO;
import com.scalar.EcomProductService.dto.ProductRequestDTO;
import com.scalar.EcomProductService.dto.ProductResponseDTO;
import com.scalar.EcomProductService.dto.ProductResponseWithoutRatingDTO;
import com.scalar.EcomProductService.exception.ProductNotFoundException;
import com.scalar.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    /** FIELD INJECTION:
    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;*/

    private final ProductService productService; //immutable

    @Autowired //Autowired for constructor injection is optional after 4.x+ version
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }


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

    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductFromId(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDTO productResponseDTO = productService.deleteProduct(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/products/{id}") //PATCH MAPPING here not supporting
    public ResponseEntity updateMappingById(@PathVariable("id") int id,
                                        @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

}

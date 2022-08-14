package com.controller;

import com.dto.ProductDto;
import com.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getProducts() {
        return productService.getProducts();
    }
}

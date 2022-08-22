package com.service;

import com.dto.ProductDto;
import com.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    void save(ProductDto productDto);

    List<ProductResponseDto> getProducts();
}

package com.service;

import com.dto.ProductDto;
import com.dto.ProductResponseDto;
//import com.repository.ProductRepository;
import com.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
//    private final ProductRepository productRepository;

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public void saveProduct(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
//     /**/   productRepository.save(product);
        log.info("product {} is created", product.getId());
    }

    public List<ProductResponseDto> getProducts() {
//        List<Product> products = productRepository.findAll();
//        return products.stream().map(this::mapToProducts).collect(Collectors.toList());
        return null;
    }

    private ProductResponseDto mapToProducts(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

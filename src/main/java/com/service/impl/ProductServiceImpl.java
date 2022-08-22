package com.service.impl;

import com.dto.ProductDto;
import com.dto.ProductResponseDto;
import com.domain.Product;
import com.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements com.service.ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductDto productDto) {
        Product product = getProduct(productDto);
        productRepository.save(product);
        log.info("product {} is created", product.getId());
    }

    public List<ProductResponseDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::mapToProducts)
                .collect(Collectors.toList());
    }

    private Product getProduct(ProductDto dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
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

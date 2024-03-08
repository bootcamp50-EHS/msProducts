package com.bootcamp.ehs.service;

import com.bootcamp.ehs.models.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> createProduct(Product product);

    Mono<Product> updateProduct(Product product, String id);

    Mono<Product> findById(String id);

    Mono<Product> findByCode(String code);

    Flux<Product> findAll();
}

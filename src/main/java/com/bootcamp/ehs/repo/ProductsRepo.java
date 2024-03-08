package com.bootcamp.ehs.repo;

import com.bootcamp.ehs.models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductsRepo extends ReactiveMongoRepository<Product, String> {

    Mono<Product> findByCodeAccount(String codeAccount);
}

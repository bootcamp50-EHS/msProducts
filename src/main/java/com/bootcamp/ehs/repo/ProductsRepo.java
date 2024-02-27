package com.bootcamp.ehs.repo;

import com.bootcamp.ehs.models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductsRepo extends ReactiveMongoRepository<Product, String> {
}

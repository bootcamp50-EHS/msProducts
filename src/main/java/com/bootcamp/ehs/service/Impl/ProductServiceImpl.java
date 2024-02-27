package com.bootcamp.ehs.service.Impl;

import com.bootcamp.ehs.models.Product;
import com.bootcamp.ehs.repo.ProductsRepo;
import com.bootcamp.ehs.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductsRepo productRepo;

    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Product product, String id) {

        return productRepo.findById(id)
                .map(productExists -> {
                    productExists.setNameAccount(product.getNameAccount());
                    productExists.setCommission(product.getCommission());
                    productExists.setLimitMovement(product.getLimitMovement());
                    productExists.setLimitNumberWithdrawal(product.getLimitNumberWithdrawal());
                    productExists.setLimitNumberDeposit(product.getLimitNumberDeposit());
                    productExists.setTypeProduct(product.getTypeProduct());
                    productExists.setLimitAccounts(product.getLimitAccounts());

                    return productExists;
                })
                .flatMap(productRepo::save);
    }

    @Override
    public Mono<Product> findById(String id) {
        return productRepo.findById(id);
    }

    @Override
    public Flux<Product> findAll() {
        return productRepo.findAll();
    }
}

package com.bootcamp.ehs.controller;

import com.bootcamp.ehs.models.Product;
import com.bootcamp.ehs.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService producService;

    @PostMapping
    public Mono<ResponseEntity<Product>> crearProducto(@RequestBody Product product){

        return producService.createProduct(product)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping
    public Flux<Product> obteberTodo(){
        return producService.findAll();
    }
}

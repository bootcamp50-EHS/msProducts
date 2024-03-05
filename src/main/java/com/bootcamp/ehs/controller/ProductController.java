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

    private final ProductService productService;

    @PostMapping
    public Mono<ResponseEntity<Product>> crearProducto(@RequestBody Product product){

        return productService.createProduct(product)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Product>> actualizarProducto(@RequestBody Product product, @PathVariable String id){
        return productService.findById(id)
                .flatMap(existingProduct ->
                        productService.updateProduct(product, id)
                                .map(updatedProduct -> ResponseEntity.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(updatedProduct))
                )
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    public Flux<Product> obteberTodo(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> obtieneId(@PathVariable String id){
        return productService.findById(id);
    }
}

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
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public Mono<ResponseEntity<Product>> crearProducto(@RequestBody Product product){

        return productService.createProduct(product)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PutMapping("/update/{id}")
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

    @GetMapping("/list")
    public Flux<Product> obteberTodo(){
        return productService.findAll();
    }

    @GetMapping("/list/{id}")
    public Mono<Product> obtieneId(@PathVariable String id){
        return productService.findById(id);
    }

    @GetMapping("/list/bycode/{codeAccount}")
    public  Mono<Product> getProductByCode(@PathVariable("codeAccount") String codeAccount){
        return productService.findByCode(codeAccount);
    }
}

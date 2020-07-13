package com.apex.samples.inventory.controller;


import com.apex.samples.inventory.entities.Product;
import com.apex.samples.inventory.filters.ProductFilter;
import com.apex.samples.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Collection<Product>> getAllProducts() {
        Collection<Product> allProduct = productService.getAllProduct();

        return ResponseEntity.ok(ProductFilter.removeRecalled(allProduct));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }


    @GetMapping("/{id}")
    ResponseEntity<Product> findProduct(@PathVariable Integer id) {
        Optional<Product> byId = productService.findById(id);

        return byId.map(ResponseEntity::ok).orElse(null);
    }
}

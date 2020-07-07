package com.apex.samples.inventory.service;

import com.apex.samples.inventory.entities.Product;
import com.apex.samples.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final InventoryRepository inventoryRepository;

    public Product save(Product product) {
        return inventoryRepository.save(product);
    }

    public Collection<Product> getAllProduct() {
        return inventoryRepository.findAll();

    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
}

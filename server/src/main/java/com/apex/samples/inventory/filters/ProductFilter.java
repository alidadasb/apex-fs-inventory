package com.apex.samples.inventory.filters;

import com.apex.samples.inventory.entities.Product;

import java.util.Collection;
import java.util.List;

public class ProductFilter {

    private final List<String> recalledProducts;

    ProductFilter(List<String> recalledProducts) {
        this.recalledProducts = recalledProducts;
    }

    public static Collection<Product> removeRecalled(Collection<Product> allProduct) {
        return allProduct;
    }
}

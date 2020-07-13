package com.apex.samples.inventory.filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ProductFilterTest {

    ProductFilter filter;

    @BeforeEach
    void before() {
        List<String> recalledProducts = new ArrayList<>();
        recalledProducts.add("Coke");
        recalledProducts.add("Gum");

        filter = new ProductFilter(recalledProducts);
    }

    @Test
    @Disabled("Not Implemented Yet")
    void testNameHere() {
        Assertions.fail();
    }
}
/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.service.ProductJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {
    @Autowired
    private ProductJpaService productJpaService;

    @GetMapping("/categories/products")
    public ArrayList<Product> getProducts() {
        return productJpaService.getProducts();
    }

    @GetMapping("/categories/products/{productId}")
    public Product getById(@PathVariable("id") int id) {
        return productJpaService.getById(id);
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return productJpaService.addProduct(product);
    }

    @PutMapping("/categories/products/{productId}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return productJpaService.updateProduct(id, product);
    }

    @DeleteMapping("/categories/products/{productId}")
    public void deleteProduct(@PathVariable int id) {
        productJpaService.deleteProduct(id);
    }

    @GetMapping("/products/{productId}/category")
    public Category getProductCategory(@PathVariable int id) {
        return productJpaService.getProductCategory(id);
    }
}
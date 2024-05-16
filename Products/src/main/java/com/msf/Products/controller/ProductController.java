package com.msf.Products.controller;

import com.msf.Products.dto.ProductRequest;
import com.msf.Products.entity.Products;
import com.msf.Products.exception.ProductNotFoundException;
import com.msf.Products.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public Long saveProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @GetMapping("/all")
    public List<Products> getAllProducts() throws ProductNotFoundException {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProductById(@PathVariable Long id, @RequestParam String name) throws ProductNotFoundException {
        return productService.updateProductById(id, name);
    }
}

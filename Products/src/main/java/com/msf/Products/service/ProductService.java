package com.msf.Products.service;

import com.msf.Products.dto.ProductRequest;
import com.msf.Products.entity.Products;
import com.msf.Products.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Long saveProduct(ProductRequest productRequest);

    List<Products> getAllProducts() throws ProductNotFoundException;

    Products getProductById(Long id) throws ProductNotFoundException;

    String deleteProductById(Long id) throws ProductNotFoundException;

    String updateProductById(Long id, String name) throws ProductNotFoundException;
}

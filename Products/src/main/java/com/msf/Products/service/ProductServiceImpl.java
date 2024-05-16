package com.msf.Products.service;

import com.msf.Products.dto.ProductRequest;
import com.msf.Products.entity.Products;
import com.msf.Products.exception.ProductNotFoundException;
import com.msf.Products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Long saveProduct(ProductRequest productRequest) {
        Products products = Products.build(0L, productRequest.getName(),
                productRequest.getDescription(), productRequest.getPrice(),
                productRequest.getQuantity());
        return productRepository.save(products).getProductId();
    }

    @Override
    public List<Products> getAllProducts() throws ProductNotFoundException {
        List<Products> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        } else {
            return products;
        }
    }

    @Override
    public Products getProductById(Long id) throws ProductNotFoundException {
        Products products = productRepository.findById(id).orElse(null);
        if (products != null) {
            return products;
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public String deleteProductById(Long id) throws ProductNotFoundException {
        Products products = productRepository.findById(id).orElse(null);
        if (products != null) {
            productRepository.deleteById(id);
            return "Hey Product is deleted";
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public String updateProductById(Long id, String name) throws ProductNotFoundException {
        Products products = productRepository.findById(id).orElse(null);
        if (products != null) {
            products.setName(name);
            productRepository.save(products);
            return "Your name is updated successfully";
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }
}

package com.msf.Products.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductRequest {
    @NotNull(message = "User name should not be null")
    private String name;
    @NotNull(message = "provide an valid description")
    private String description;
    @NotNull(message = "price should not be null")
    private Double price;
    private int quantity;
}

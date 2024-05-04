package com.example.Product.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponse {
    private int id;
    private String name;
    private String descripation;
    private BigDecimal price;
}

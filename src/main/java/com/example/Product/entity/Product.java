package com.example.Product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.math.BigDecimal;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//@RedisHash("Product")
public class Product implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String descripation;
    private BigDecimal price;



}

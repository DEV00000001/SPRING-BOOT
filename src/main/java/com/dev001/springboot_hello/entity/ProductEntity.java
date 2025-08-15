package com.dev001.springboot_hello.entity;

import java.math.BigDecimal;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "java_product_001")
public class ProductEntity {
  private Long id;
  private String productName;
  private BigDecimal productPrice;
  
  // get 
  
  // set
  
}

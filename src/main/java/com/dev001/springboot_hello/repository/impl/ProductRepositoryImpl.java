package com.dev001.springboot_hello.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev001.springboot_hello.entity.ProductEntity;
import com.dev001.springboot_hello.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
  @Override
  public ProductEntity createProduct(ProductEntity product) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setId(1L);
    productEntity.setProductName("product A");
    productEntity.setProductPrice(new BigDecimal("21.6"));
    return productEntity;

  }

  public List<ProductEntity> findAllProducts() {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setId(1L);
    productEntity.setProductName("product A");
    productEntity.setProductPrice(new BigDecimal("21.6"));
    return List.of(productEntity);
  }
  
  
}

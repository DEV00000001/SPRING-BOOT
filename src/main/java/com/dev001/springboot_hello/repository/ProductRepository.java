package com.dev001.springboot_hello.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev001.springboot_hello.entity.ProductEntity;

@Repository
public interface ProductRepository {

  ProductEntity createProduct(ProductEntity product);

  List<ProductEntity> findAllProducts();
} 

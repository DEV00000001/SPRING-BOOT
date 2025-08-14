package com.dev001.springboot_hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev001.springboot_hello.entity.ProductEntity;

@Service
public interface ProductService {
  ProductEntity createProduct(ProductEntity product);

  List<ProductEntity> findAllProducts();

}

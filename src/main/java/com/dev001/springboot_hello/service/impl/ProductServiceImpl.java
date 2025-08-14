package com.dev001.springboot_hello.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev001.springboot_hello.entity.ProductEntity;
import com.dev001.springboot_hello.repository.ProductRepository;
import com.dev001.springboot_hello.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;



  @Override
  public ProductEntity createProduct(ProductEntity product) {
    return productRepository.createProduct(product);
  }

  @Override
  public List<ProductEntity> findAllProducts() {
    return productRepository.findAllProducts();
  }
}

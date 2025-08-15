package com.dev001.springboot_hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev001.springboot_hello.entity.ProductEntity;
import com.dev001.springboot_hello.service.ProductService;

@RestController
@RequestMapping("v1/api")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/product/add")
  public ProductEntity createProduct(ProductEntity productEntity) {

    return productService.createProduct(productEntity);

  }

  @GetMapping("/products")
  public List<ProductEntity> getAllProducts() {
    return productService.findAllProducts();
  }

}

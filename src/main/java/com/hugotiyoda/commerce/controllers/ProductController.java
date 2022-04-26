package com.hugotiyoda.commerce.controllers;


import com.hugotiyoda.commerce.entities.Product;
import com.hugotiyoda.commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> insertNewProduct(Product product) {
        return new ResponseEntity<>(productService.insertNewProduct(product), HttpStatus.CREATED);
    }


    //tByID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getById(@PathVariable Long productID) {
        return new ResponseEntity<>(productService.getProductById(productID), HttpStatus.OK);
    }

    //All
    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
        return new ResponseEntity<>(productService.getAllProducts(pageable), HttpStatus.OK);
    }


}

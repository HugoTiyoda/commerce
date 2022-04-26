package com.hugotiyoda.commerce.services;


import com.hugotiyoda.commerce.entities.Product;
import com.hugotiyoda.commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //all
    public Page<Product> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    //byId
    public Product getProductById(Long productPurchasedID) {
        return productRepository.findById(productPurchasedID).orElse(null);
    }

    //
    public Product insertNewProduct(Product product){
        return productRepository.save(product);
    }

}

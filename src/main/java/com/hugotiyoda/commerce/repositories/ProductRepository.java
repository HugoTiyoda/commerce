package com.hugotiyoda.commerce.repositories;

import com.hugotiyoda.commerce.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
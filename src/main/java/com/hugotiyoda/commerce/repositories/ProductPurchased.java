package com.hugotiyoda.commerce.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPurchased extends PagingAndSortingRepository<ProductPurchased,Long> {
}

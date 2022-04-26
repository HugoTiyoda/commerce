package com.hugotiyoda.commerce.repositories;

import com.hugotiyoda.commerce.entities.ProductPurchased;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPurchasedRepository extends PagingAndSortingRepository<ProductPurchased,Long> {
}

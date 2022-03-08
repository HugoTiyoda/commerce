package com.hugotiyoda.commerce.repositories;

import com.hugotiyoda.commerce.entities.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}

package com.hugotiyoda.commerce.repositories;

import com.hugotiyoda.commerce.entities.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City,Long> {
}

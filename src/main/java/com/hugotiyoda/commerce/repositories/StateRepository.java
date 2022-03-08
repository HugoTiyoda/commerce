package com.hugotiyoda.commerce.repositories;

import com.hugotiyoda.commerce.entities.State;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends PagingAndSortingRepository<State,Long> {
}

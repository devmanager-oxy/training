package com.oxy.product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDAO extends PagingAndSortingRepository<Product, String> {
}

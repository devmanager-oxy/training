package com.oxy.product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductCategoryDAO extends PagingAndSortingRepository<ProductCategory, String> {
}

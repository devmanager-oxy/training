package com.oxy.product;

import java.util.List;

public interface ProductService {

    void saveProductCategory(ProductCategory productCategory);

    void saveProduct(Product product);

    ProductCategory findById(String id);

    List<Product> findAllProducts();
}

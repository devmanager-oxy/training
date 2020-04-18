package com.oxy.product;

import java.util.List;

public interface ProductService {

    void saveProductCategory(ProductCategory productCategory);

    void saveProduct(Product product);

    ProductCategory findCategoryById(String id);

    Product findProductById(String id);

    List<Product> findAllProducts();
}

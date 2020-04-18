package com.oxy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("ProductService")
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService{

    private ProductDAO productDAO;
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, ProductCategoryDAO productCategoryDAO) {
        this.productDAO = productDAO;
        this.productCategoryDAO = productCategoryDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public ProductCategory findCategoryById(String id) {
        return productCategoryDAO.findById(id).orElse(new ProductCategory());
    }

    @Override
    public Product findProductById(String id) {
        return productDAO.findById(id).orElse(new Product());
    }

    @Override
    @Transactional(readOnly = false)
    public void saveProductCategory(ProductCategory productCategory) {
        productCategoryDAO.save(productCategory);
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        productDAO.findAll().forEach(products::add);
        return products;
    }
}

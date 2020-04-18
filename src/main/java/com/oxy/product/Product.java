package com.oxy.product;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private String id;

    @Column(name = "name")
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", foreignKey = @ForeignKey(name = "category_id_fk"))
    private ProductCategory productCategory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}

package com.oxy.invoice;

import com.oxy.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="invoice_item")
public class InvoiceItem {

    @Id
    private String Id;

    @Column(name = "qty", scale = 2, precision = 5)
    private BigDecimal qty;

    @Column(name = "price", scale = 3, precision = 10)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "product_invoice_item_fk"))
    private Product product;

    @Column(name="product_id", insertable = false, updatable = false)
    private String productId;

    @ManyToOne
    @JoinColumn(name="invoice_id",foreignKey = @ForeignKey(name = "invoice_invoice_item_fk"))
    private Invoice invoice;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

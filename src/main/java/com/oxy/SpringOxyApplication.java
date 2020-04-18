package com.oxy;

import com.oxy.customer.Customer;
import com.oxy.customer.CustomerService;
import com.oxy.product.Product;
import com.oxy.product.ProductCategory;
import com.oxy.product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringOxyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringOxyApplication.class, args);
		ProductService productService = (ProductService) ctx.getBean("ProductService");

		String categoryUID = (UUID.randomUUID().toString());
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(categoryUID);
		productCategory.setCategoryName("Makanan");
		productService.saveProductCategory(productCategory);

		ProductCategory category = productService.findById(categoryUID);
		Product product = new Product();
		product.setId(UUID.randomUUID().toString());
		product.setProductName("Nasi Goreng");
		product.setProductCategory(category);
		productService.saveProduct(product);

		List<Product> products = productService.findAllProducts();
		products.forEach(data -> System.out.println(data.getId() + " | " + data.getProductName() +
				"  | " + data.getProductCategory().getCategoryName()));
	}
}

package com.oxy;

import com.oxy.customer.Customer;
import com.oxy.customer.CustomerService;
import com.oxy.invoice.Invoice;
import com.oxy.invoice.InvoiceItem;
import com.oxy.invoice.InvoiceService;
import com.oxy.product.Product;
import com.oxy.product.ProductCategory;
import com.oxy.product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringOxyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringOxyApplication.class, args);
	}
}

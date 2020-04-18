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
		ProductService productService = (ProductService) ctx.getBean("ProductService");
		InvoiceService invoiceService = (InvoiceService) ctx.getBean("InvoiceService");
		CustomerService customerService = (CustomerService) ctx.getBean("CustomerService");
		Customer customer = new Customer();
		customer.setId(UUID.randomUUID().toString());
		customer.setName("Adi");
		customer.setAddress("Pancoran");
		customerService.saveCustomer(customer);

		/*String categoryUID = UUID.randomUUID().toString();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(categoryUID);
		productCategory.setCategoryName("Makanan");
		//productService.saveProductCategory(productCategory);

		ProductCategory category = productService.findCategoryById(categoryUID);
		Product product1 = new Product();
		product1.setId(UUID.randomUUID().toString());
		product1.setProductName("Ayam bakar");
		product1.setProductCategory(category);
		//productService.saveProduct(product1);

		Product product2 = new Product();
		product2.setId(UUID.randomUUID().toString());
		product2.setProductName("Cap Cay");
		product2.setProductCategory(category);
		//productService.saveProduct(product2);

		Invoice invoice = new Invoice();
		invoice.setId(UUID.randomUUID().toString());
		invoice.setInvoiceDate(new Date());
		invoice.setInvoiceNumber("OXY00001");

		InvoiceItem invoiceItem1 = new InvoiceItem();
		invoiceItem1.setId(UUID.randomUUID().toString());
		invoiceItem1.setPrice(BigDecimal.valueOf(3000));
		invoiceItem1.setQty(BigDecimal.valueOf(2));
		Product ayamBakar = productService.findProductById(product1.getId());
		invoiceItem1.setProduct(ayamBakar);
		invoiceItem1.setInvoice(invoice);

		InvoiceItem invoiceItem2 = new InvoiceItem();
		invoiceItem2.setId(UUID.randomUUID().toString());
		invoiceItem2.setPrice(BigDecimal.valueOf(3000));
		invoiceItem2.setQty(BigDecimal.valueOf(2));
		Product capCay = productService.findProductById(product2.getId());
		invoiceItem2.setProduct(capCay);
		invoiceItem2.setInvoice(invoice);

		List<InvoiceItem> invoiceItems = new ArrayList<>();
		invoiceItems.add(invoiceItem1);
		invoiceItems.add(invoiceItem2);
		invoice.setInvoiceItems(invoiceItems);

		//invoiceService.saveInvoice(invoice);

		List<Invoice> invoices = invoiceService.findAllInvoice();
		for(Invoice invoice1 : invoices){
			System.out.println(invoice1.getInvoiceNumber() + " | " + invoice1.getInvoiceDate());
			for(InvoiceItem invoiceItem : invoice1.getInvoiceItems()){
				System.out.println(invoiceItem.getProductId());
				Product product = productService.findProductById(invoiceItem.getProductId());
				System.out.println(product.getProductName()+ " | " + invoiceItem.getQty() +
						" | " + invoiceItem.getPrice());
			}
		}*/
	}
}

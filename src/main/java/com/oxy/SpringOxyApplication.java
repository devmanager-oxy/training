package com.oxy;

import com.oxy.customer.Customer;
import com.oxy.customer.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringOxyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringOxyApplication.class, args);
		CustomerService customerService = (CustomerService) ctx.getBean("CustomerService");
		Customer customer = new Customer();
		customer.setId(UUID.randomUUID().toString());
		customer.setName("Adi");
		customer.setAddress("Pancoran");
		//customerService.saveCustomer(customer);
		List<Customer> customers = customerService.findAll();
		for (Customer cust : customers) {
			System.out.println(" Id :" + cust.getId() + " | name :" + cust.getName());
		}

		Customer customer1 = new Customer();
		customer1.setId(UUID.randomUUID().toString());
		customer1.setName("Budi");
		customer1.setAddress("Pancoran");
		//customerService.saveCustomer(customer1);
		customers = customerService.findByName("Budi");
		System.out.println("Find by name");
		for (Customer cust : customers) {
			System.out.println(" Id :" + cust.getId() + " | name :" + cust.getName());
		}
		customers = customerService.pagingCustomer(0, 1);
		System.out.println("page customer");
		customers.forEach(cust ->
				System.out.println(" Id :" + cust.getId() + " | name :" + cust.getName()));
	}
}

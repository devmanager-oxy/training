package com.oxy.customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer findById(String id);

    List<Customer> findAll();

    List<Customer> findByName(String customerName);

    List<Customer> pagingCustomer(int page, int size);
}

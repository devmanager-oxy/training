package com.oxy.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("CustomerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerDAO.findById(id)
                .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        customerDAO.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    @Override
    public List<Customer> findByName(String customerName) {
        return customerDAO.findByName("%" + customerName + "%");
    }

    @Override
    public List<Customer> pagingCustomer(int page, int size) {
        List<Customer> customers = new ArrayList<>();
        Pageable custPage = PageRequest.of(page, size, Sort.by("name"));
        customerDAO.findAll(custPage).forEach(customers::add);
        return customers;
    }

}

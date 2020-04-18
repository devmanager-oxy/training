package com.oxy.customer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerDAO extends PagingAndSortingRepository<Customer, String> {

    @Query("select c from Customer c where c.name like :name ") //hql
    List<Customer> findByName(String name);

    @Query("Delete from Customer c where c.name ilike :name")
    @Modifying
    void deleteCustomerByName(String name);
}

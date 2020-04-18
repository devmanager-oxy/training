package com.oxy.customer;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findCustomers(){
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(value = "/customers/{guid}")
    public ResponseEntity<Customer> findCustomersById(@PathVariable("guid") String id){
        Customer customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping(value="/customers")
    public ResponseEntity saveCustomer(@Valid @RequestBody Customer customer){
        customer.setId(UUID.randomUUID().toString());
        customerService.saveCustomer(customer);
        return ResponseEntity.created(URI.create("http://localhost:8080/customers/" + customer.getId())).build();
    }

    @PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") String id){
        customerService.updateCustomer(customer, id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") String id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

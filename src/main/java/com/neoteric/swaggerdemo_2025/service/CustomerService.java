package com.neoteric.swaggerdemo_2025.service;

import com.neoteric.swaggerdemo_2025.entity.Customer;
import com.neoteric.swaggerdemo_2025.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(String firstName, String adharNumber) {
        if (firstName == null && adharNumber == null) {
            return customerRepository.findAll();
        }
        return customerRepository.findByFirstNameContainingAndAdharNumberContaining(
                firstName != null ? firstName : "",
                adharNumber != null ? adharNumber : ""
        );
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }
}

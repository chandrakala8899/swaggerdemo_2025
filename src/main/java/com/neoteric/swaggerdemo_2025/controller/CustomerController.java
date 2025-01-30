package com.neoteric.swaggerdemo_2025.controller;

import com.neoteric.swaggerdemo_2025.entity.Customer;
import com.neoteric.swaggerdemo_2025.response.ApiResponse;
import com.neoteric.swaggerdemo_2025.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<Customer>> createCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(new ApiResponse<>(true, "Customer created successfully", savedCustomer));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Customer>>> getAllCustomers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String adharNumber) {
        List<Customer> customers = customerService.getAllCustomers(firstName, adharNumber);
        return ResponseEntity.ok(new ApiResponse<>(true, "Customers retrieved successfully", customers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Customer not found"));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Customer found", customer));
    }
}

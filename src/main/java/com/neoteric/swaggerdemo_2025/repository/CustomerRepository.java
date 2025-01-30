package com.neoteric.swaggerdemo_2025.repository;

import com.neoteric.swaggerdemo_2025.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
   List<Customer> findByNameContaining(String firstname); // Separate methods

   List<Customer> findByAdharNumberContaining(String adharNumber);

   List<Customer> findByFirstNameContainingAndAdharNumberContaining(String firstName, String adharNumber);


}

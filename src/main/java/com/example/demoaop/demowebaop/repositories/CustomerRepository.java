package com.example.demoaop.demowebaop.repositories;

import java.util.List;

import com.example.demoaop.demowebaop.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}

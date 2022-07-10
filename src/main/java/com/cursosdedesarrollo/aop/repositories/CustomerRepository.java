package com.cursosdedesarrollo.aop.repositories;

import java.util.List;

import com.cursosdedesarrollo.aop.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}

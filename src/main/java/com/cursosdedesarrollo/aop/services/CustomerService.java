package com.cursosdedesarrollo.aop.services;

import com.cursosdedesarrollo.aop.domain.Customer;
import com.cursosdedesarrollo.aop.repositories.CustomerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> list(){
        return Lists.newArrayList(this.customerRepository.findAll());
    }

    public Optional<Customer> getById(Long id){
        return this.customerRepository.findById(id);
    }
}

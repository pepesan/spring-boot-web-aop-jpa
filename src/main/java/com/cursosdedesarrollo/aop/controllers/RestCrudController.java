package com.cursosdedesarrollo.aop.controllers;

import com.cursosdedesarrollo.aop.advices.ResourceNotFoundException;
import com.cursosdedesarrollo.aop.domain.Customer;
import com.cursosdedesarrollo.aop.repositories.CustomerRepository;
import com.cursosdedesarrollo.aop.services.CustomerService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestCrudController {
    @Autowired
    public CustomerService customerService;
    @GetMapping("/customer")
    public List<Customer> getList() {
        return  Lists.newArrayList(customerService.list());
    }
    @GetMapping("/customer/{id}")
    public Customer getList(@PathVariable Long id) {
        return this.customerService.getById(id).orElse(new Customer());
    }
    @GetMapping("/customer/excepcion")
    public Customer getException() throws Exception {
        return this.customerService.getById(0L).orElseThrow(Exception::new);


    }
    @GetMapping("/customer/advice")
    public Customer getResourceNotFoundException() throws ResourceNotFoundException {
        return this.customerService.getById(0L).orElseThrow(() -> new ResourceNotFoundException("Not found Customer with id = " + 0L));


    }

}

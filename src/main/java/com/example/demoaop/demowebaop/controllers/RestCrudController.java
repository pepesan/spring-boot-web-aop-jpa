package com.example.demoaop.demowebaop.controllers;

import com.example.demoaop.demowebaop.domain.Customer;
import com.example.demoaop.demowebaop.repositories.CustomerRepository;
import com.google.common.collect.Lists;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestCrudController {
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    public CustomerRepository repository;
    @GetMapping("/customer")
    public List<Customer> list() {
        return  Lists.newArrayList(repository.findAll());
    }
}

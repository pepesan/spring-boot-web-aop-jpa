package com.example.demoaop.demowebaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {
    @Before("execution(public java.util.List<com.example.demoaop.demowebaop.domain.Customer> list(..))")
    public void antesListadoClientes(){
        System.out.println("extrayendo el listado de clientes");
    }
    @After("execution(public java.util.List<com.example.demoaop.demowebaop.domain.Customer> list(..))")
    public void despuesListadoClientes(){
        System.out.println("saliendo del listado de clientes");
    }
    
}

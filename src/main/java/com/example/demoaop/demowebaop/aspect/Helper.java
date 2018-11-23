package com.example.demoaop.demowebaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {
    //cualquier función list
    @Before("execution(public java.util.List<com.example.demoaop.demowebaop.domain.Customer> list(..))")
    public void antesListadoClientesGlobal(){
        System.out.println("extrayendo el listado de clientes");
    }
    //una función en concreto
    @Before("execution(public java.util.List<com.example.demoaop.demowebaop.domain.Customer> com.example.demoaop.demowebaop.controllers.RestCrudController.list(..))")
    public void antesListadoClientesLocal(){
        System.out.println("extrayendo el listado de clientes");
    }
    //Después de una función
    @After("execution(public java.util.List<com.example.demoaop.demowebaop.domain.Customer> list(..))")
    public void despuesListadoClientes(){
        System.out.println("saliendo del listado de clientes");
    }
    @AfterReturning(pointcut = "execution(public java.util.List<com.example.demoaop.demowebaop.domain.Customer> list(..))",returning="list")
    public void despuesDevolverListadoClientes(java.util.List<com.example.demoaop.demowebaop.domain.Customer> list){
        System.out.println("saliendo del listado de clientes:"+list);
    }
    //Después de una función
    @Around("execution(public java.util.List<com.example.demoaop.demowebaop.domain.Customer> list(..))")
    public Object alrededorDeListadoClientes(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("alrededor de listado de clientes");
        // start stopwatch
        Object retVal = pjp.proceed();
        System.out.println("around object: "+retVal);
        // stop stopwatch
        return retVal;
    }

}

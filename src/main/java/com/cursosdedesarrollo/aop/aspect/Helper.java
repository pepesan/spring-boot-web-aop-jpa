package com.cursosdedesarrollo.aop.aspect;

import com.cursosdedesarrollo.aop.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
@EnableAspectJAutoProxy
@Slf4j
public class Helper {
    //cualquier función list
    @Before("execution(public java.util.List<com.cursosdedesarrollo.aop.domain.Customer> list(..))")
    public void antesListadoClientesGlobal(){
        log.info("@Before de list");
    }
    //una función en concreto
    @Before("execution(public java.util.List<com.cursosdedesarrollo.aop.domain.Customer> com.cursosdedesarrollo.aop.controllers.RestCrudController.list(..))")
    public void antesListadoClientesLocal(){
        log.info("otro @Before de list");
    }
    //Después de una función
    @After("execution(public java.util.List<com.cursosdedesarrollo.aop.domain.Customer> list(..))")
    public void despuesListadoClientes(){
        log.info("@After de list");
    }
    @AfterReturning(pointcut = "execution(public java.util.List<com.cursosdedesarrollo.aop.domain.Customer> list(..))",returning="list")
    public void despuesDevolverListadoClientes(java.util.List<Customer> list){
        log.info("@AfterReturning de list: "+ list);
    }
    //Después de una función
    @Around("execution(public java.util.List<com.cursosdedesarrollo.aop.domain.Customer> list(..))")
    public Object alrededorDeListadoClientes(ProceedingJoinPoint pjp) throws Throwable{
        log.info("@Around de list: antes. ");
        // start stopwatch
        Object retVal = pjp.proceed();
        log.info("@Around de list: después: "+ retVal);
        // stop stopwatch
        return retVal;
    }

}

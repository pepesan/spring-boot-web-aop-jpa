package com.cursosdedesarrollo.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class MiAspecto {

    // valor devuelto -> nombre método -> parámetros
    @Before("execution(* getById(Long))")
    public void beforegetByIdLong(){
        log.info("* getById(Long)");
    }
    // modificador -> valor devuelto -> nombre método -> parámetros
    @Before("execution(public * getById(Long))")
    public void publicbeforegetByIdLong(){
        log.info("public * getById(Long)");
    }

    // modificador -> valor devuelto -> nombre método -> parámetros
    @Before("execution(public * getById(Long))")
    public void publicbeforegetByIdLongJoinPoint(JoinPoint joinPoint){
        log.info("public * getById(Long): JoinPoint: "+ joinPoint + ": Args: " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterThrowing(value="execution(* com.cursosdedesarrollo.aop.controllers.RestCrudController.getException(..))",throwing="ex")
    public void pillaExcepcion(JoinPoint joinPoint, Exception ex){
        log.info("Excepción en: "+ joinPoint.toString() + ": Excepción: "+ ex.getMessage());
    }
}

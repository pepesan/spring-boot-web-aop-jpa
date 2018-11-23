package com.example.demoaop.demowebaop.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

    protected final Log logger = LogFactory.getLog(getClass());
    @GetMapping("/saludo")
    public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return new ModelAndView("saludo","name", name);
    }
}

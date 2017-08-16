package com.sda.springcourse.controller;

import com.sda.springcourse.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private ReverseService reverseService;
//    zamiast konstruktora

    @Autowired
//    @Qualifier(value = "lowerCaseService")
//    private  ReverseService ddd;
    private ReverseService lowerCaseService;

    @RequestMapping(path = "/home")
//    @PostMapping(path = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "/home", params = "m")
    public ModelAndView home(@RequestParam("m") String message) {
        String reverseMessage = reverseService.reverse(message);
        System.out.println(reverseMessage);
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/home", params = {"m", "lowercase"})
    public ModelAndView homeLowerCase(@RequestParam(name = "m")String message ) {
        String reverse = lowerCaseService.reverse(message);
        System.out.println("lower case");
        System.out.println(reverse);
        return new ModelAndView("index");
    }

}
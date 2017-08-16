package com.sda.springcourse.controller;

import com.sda.springcourse.model.User;
import com.sda.springcourse.repository.UserRepository;
import com.sda.springcourse.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

@Controller
public class HomeController {

    @Autowired
    private ReverseService reverseService;
//    zamiast konstruktora

    @Autowired
//    @Qualifier(value = "lowerCaseService")
//    private  ReverseService ddd;
    private ReverseService lowerCaseService;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(path = "/home")
//    @PostMapping(path = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("firstName", "Ula");
        modelAndView.addObject("phoneNumber", "123445678");
        return modelAndView;
    }

    @RequestMapping(value = "/home", params = "m")
    public ModelAndView home(@RequestParam("m") String message) {
        String reverseMessage = reverseService.reverse(message);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", reverseMessage);
        return modelAndView;
    }
    @RequestMapping(value = "/home", params = {"m", "lowercase"})
    public ModelAndView homeLowerCase(@RequestParam(name = "m")String message,
                                      @RequestParam(value = "p" , required = false, defaultValue = "1" ) Integer page) {
        String reverse = lowerCaseService.reverse(message);
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("message", reverse);
        return  modelAndView;
    }

    @RequestMapping(value = "/home/{userId}")
    public ModelAndView homeParam(@PathVariable("userId") Integer userId) {
        User user = userRepository.getById(userId);

        ModelAndView modelAndview = new ModelAndView("index");
        modelAndview.addObject("userId", userId);

        return modelAndview;
    }

}
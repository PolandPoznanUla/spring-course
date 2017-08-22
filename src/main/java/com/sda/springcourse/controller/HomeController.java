package com.sda.springcourse.controller;

import com.sda.springcourse.model.User;
import com.sda.springcourse.repository.UserRepository;
import com.sda.springcourse.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private ReverseService reverseService;

    @Autowired
    private ReverseService lowerCaseService;

    @GetMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("firstName", "Szymon");
        modelAndView.addObject("phoneNumber", 1234567);
        return modelAndView;
    }

    @GetMapping(value = "/home", params = "m")
    public ModelAndView home(@RequestParam("m") String message) {
        String reverseMessage = reverseService.reverse(message);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("firstName", "Szymon");
        modelAndView.addObject("phoneNumber", 1234567);
        modelAndView.addObject("message", reverseMessage);
        return modelAndView;
    }

    @GetMapping(value = "/home", params = {"m", "lowercase"})
    public ModelAndView homeLowerCase(@RequestParam("m") String message,
                                      @RequestParam(value = "p", required = false, defaultValue = "1") Integer page) {
        String reverse = lowerCaseService.reverse(message);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("firstName", "Szymon");
        modelAndView.addObject("phoneNumber", 1234567);
        modelAndView.addObject("message", reverse);
        return modelAndView;
    }
}

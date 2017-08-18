package com.sda.springcourse.controller;

import com.sda.springcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.getAll());
        return modelAndView;
    }

    @RequestMapping(params = {"lastName"})
    public ModelAndView usersByLastName(@RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.getAllByLastName(lastName));
        return modelAndView;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView specifiedUser(@PathVariable("id") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", userRepository.getById(userId));
        return modelAndView;
    }
    //requestMapping (/test/users)
    //requestMapping (/test/users) ?lastName (startsWith)
    //requestMapping (/test/users/{userId}) -> user.html
}

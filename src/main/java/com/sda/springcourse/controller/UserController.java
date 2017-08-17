package com.sda.springcourse.controller;

import com.sda.springcourse.model.User;
import com.sda.springcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/test/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.getAll());
        return modelAndView;
    }

    @RequestMapping(params = "lastName")
    public ModelAndView usersByLastName(@RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.getAllByLastName(lastName));
        return modelAndView;

    }

    @RequestMapping(value = "/{userId}")
    public ModelAndView specifiedUser(@PathVariable Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", userRepository.getById(userId));
        return modelAndView;
    }
}

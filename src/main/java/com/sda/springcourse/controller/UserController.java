package com.sda.springcourse.controller;

import com.sda.springcourse.model.CreationStatus;
import com.sda.springcourse.model.CreationStatusFactory;
import com.sda.springcourse.model.News;
import com.sda.springcourse.model.User;
import com.sda.springcourse.repository.JpaNewsRepository;
import com.sda.springcourse.repository.JpaUserRepository;
import com.sda.springcourse.repository.NewsRepository;
import com.sda.springcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private JpaNewsRepository newsRepository;

    @Autowired
    private CreationStatusFactory creationStatusFactory;

    @GetMapping
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.findAll());
        return modelAndView;
    }

    @GetMapping(params = {"lastName"})
    public ModelAndView usersByLastName(@RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.findByLastName(lastName));
        return modelAndView;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView specifiedUser(@PathVariable("id") Integer userId) {
        User user = userRepository.findOne(userId);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        modelAndView.addObject("allNews", newsRepository.findByUser(user));
        return modelAndView;
    }

    @PostMapping(path = "/{userId}/news")
    public ModelAndView addNews(@ModelAttribute News news, @PathVariable("userId") Integer userId) {
        User user = userRepository.findOne(userId);
        news.setUser(user);
        newsRepository.save(news);
        ModelAndView modelAndView = specifiedUser(userId);
        CreationStatus creationStatus = true ?
                creationStatusFactory.createSuccessStatus("Successfully created news.") :
                creationStatusFactory.createFailureStatus("Couldn't create news");

        modelAndView.addObject("creationStatus", creationStatus);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute User user) {
        userRepository.save(user);
        ModelAndView modelAndView = users();
        CreationStatus creationStatus = true ?
                creationStatusFactory.createSuccessStatus("Successfully created user.") :
                creationStatusFactory.createFailureStatus("Couldn't create user");
        modelAndView.addObject("creationStatus", creationStatus);
        return modelAndView;

    }
}

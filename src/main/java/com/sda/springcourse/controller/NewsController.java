package com.sda.springcourse.controller;

import com.sda.springcourse.repository.NewsRepository;
import com.sda.springcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping
    public ModelAndView allNews() {
        ModelAndView modelAndView = new ModelAndView("allNews");
        modelAndView.addObject("allNews", newsRepository.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/{newsId}")
    public ModelAndView news(@PathVariable("newsId") Integer id) {
        ModelAndView modelAndView = new ModelAndView("news");
        modelAndView.addObject("news", newsRepository.getById(id));
        return modelAndView;
    }

}

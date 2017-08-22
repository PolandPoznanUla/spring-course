package com.sda.springcourse.controller;

import com.sda.springcourse.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping
    public ModelAndView news() {
        ModelAndView modelAndView = new ModelAndView("allNews");
        modelAndView.addObject("allNews", newsRepository.getAll());
        return modelAndView;
    }

    @GetMapping(path = "/{newsId}")
    public ModelAndView singleNews(@PathVariable("newsId") Integer id) {
        ModelAndView modelAndView = new ModelAndView("news");
        modelAndView.addObject("news", newsRepository.getById(id));
        return modelAndView;
    }

    @PostMapping(path = "/{newsId}/delete")
    public String removeNews(@PathVariable("newsId") Integer id) {
        newsRepository.remove(id);
        return "redirect:/news/";
    }
}

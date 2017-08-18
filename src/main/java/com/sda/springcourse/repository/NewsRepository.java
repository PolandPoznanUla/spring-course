package com.sda.springcourse.repository;

import com.sda.springcourse.model.News;

import java.util.List;

public interface NewsRepository {
    List<News> getAll();

    News getById(Integer id);
}

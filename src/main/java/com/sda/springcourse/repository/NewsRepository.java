package com.sda.springcourse.repository;

import com.sda.springcourse.model.News;

import java.util.List;

public interface NewsRepository {
    List<News> getAll();

    News getById(Integer id);

    List<News> getByUserId(Integer userId);

    boolean add(News news);

    boolean remove(Integer id);
}

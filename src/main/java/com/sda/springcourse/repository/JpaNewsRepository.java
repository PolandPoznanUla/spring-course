package com.sda.springcourse.repository;

import com.sda.springcourse.model.News;
import com.sda.springcourse.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaNewsRepository extends CrudRepository<News, Integer> {
    List<News> findByUser(User user);
}

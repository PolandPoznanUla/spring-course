package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;

import java.util.List;

/**
 * Created by RENT on 2017-08-16.
 */
public interface UserRepository {
    List<User> getAll();
    User getById(Integer id);
}

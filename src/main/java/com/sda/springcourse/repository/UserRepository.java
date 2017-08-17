package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User getById(Integer id);
}

package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    List<User> getAllByLastName(String lastName);

    User getById(Integer id);

    boolean add(User user);
}

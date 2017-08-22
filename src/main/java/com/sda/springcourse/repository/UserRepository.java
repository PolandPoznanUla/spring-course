package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    List<User> getAllByLastName(String lastName);

    User getById(Integer id);

    boolean add(User user);
}

//1. zaimplementowac add
//2. utworzyc formularz na users.html
//3. utworzyc PostMapping w UserController
//4. dodac do ModelAndView odpowiedni CreationStatus
//5. wyswietlic creationStatus-alert w html

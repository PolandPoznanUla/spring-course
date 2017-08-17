package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockUserRepository implements UserRepository {

    private List<User> users;

    public MockUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(Integer id) {
        return users.get(id);
    }

    @PostConstruct
    public void init() {
        User user = new User(1, "Szymon", "Nowak", "12345677889");
        User user1 = new User(2, "Anna", "Kowalska", "6785939573");
        User user2 = new User(3, "Andrzej", "Duda", "8472547593");

        users.add(user);
        users.add(user1);
        users.add(user2);
    }
}

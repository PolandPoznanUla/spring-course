package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by RENT on 2017-08-16.
 */
@Component
public class MockUserRepository implements UserRepository{

    private List<User> users;



    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @PostConstruct
    public void init() {
        User user = new User(1, "Ula", "Radoń", "123456789");
        User user1 = new User(2, "Ala", "Makota", "223456789");
        User user2 = new User(3, "Ola", "Mapsa", "323456789");
        users.add(user);
        users.add(user1);
        users.add(user2);
    }
}

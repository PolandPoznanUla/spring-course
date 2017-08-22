package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by RENT on 2017-08-22.
 */
public interface JpaUserRepository extends CrudRepository <User, Integer> {

    List<User> findByLastName(String lastName);

}

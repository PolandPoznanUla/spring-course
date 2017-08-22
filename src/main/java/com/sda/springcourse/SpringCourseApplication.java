package com.sda.springcourse;

import com.sda.springcourse.model.User;
import com.sda.springcourse.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringCourseApplication {

	@Autowired
	private JpaUserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
	}

	@PostConstruct
	public void init() {
		repository.save(new User("Ula", "Radoń", "555 123 456"));
		repository.save(new User("Ola", "Makota", "123 123 456"));
		repository.save(new User("Szymon", "Nowak", "456 123 456"));
	}
}

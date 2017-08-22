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
		repository.save(new User("Szymon", "Nowak", "1245778"));
		repository.save(new User("Jan", "Kowalski", "968744928492"));
		repository.save(new User("Karolina", "Wisniewska", "875854764"));
	}
}

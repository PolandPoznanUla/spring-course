package com.sda.springcourse;

import com.sda.springcourse.model.News;
import com.sda.springcourse.model.User;

import com.sda.springcourse.repository.JpaNewsRepository;
import com.sda.springcourse.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringCourseApplication {

	@Autowired
	private JpaUserRepository userRepository;

	@Autowired
	private JpaNewsRepository newsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
	}

	@PostConstruct
	public void init() {
		userRepository.save(new User("Szymon", "Nowak", "1245778"));
		userRepository.save(new User("Jan", "Kowalski", "968744928492"));
		userRepository.save(new User("Karolina", "Wisniewska", "875854764"));

		News newsArticle = new News("Policja bije bezbronnych!", "Policja bije biednych i bezbronnych obywateli! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "http://karkolomny.blog.pl/files/2017/05/policja-bije-900x631.jpg", "http://karkolomny.blog.pl/files/2017/05/policja-bije-900x631.jpg", userRepository.findOne(1));
        News newsArticle2 = new News( "SZOK! Kaczynski jest kobietą!!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "https://img2.cda.pl/g/16713_16c9611659bb23788c7ac11ac25eda9b.jpeg", "https://img2.cda.pl/g/16713_16c9611659bb23788c7ac11ac25eda9b.jpeg", userRepository.findOne(2));
        News newsArticle3 = new News( "NIEDOWIERZANIE! LEKARZE ICH NIENAWIDZĄ!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://i1.kwejk.pl/k/obrazki/2016/06/baa89ad83053312302baf90b6b15f6b4.jpg", "https://i1.kwejk.pl/k/obrazki/2016/06/baa89ad83053312302baf90b6b15f6b4.jpg", userRepository.findOne(2));
        News newsArticle4 = new News("HAZARDZISCI GO NIENAWIDZA! SZOKUJACE!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "http://www.penera.pl/upload/images/2016/02/hazardzisci_go_nienawidza_2016-02-29_14-46-47.jpg", "http://www.penera.pl/upload/images/2016/02/hazardzisci_go_nienawidza_2016-02-29_14-46-47.jpg", userRepository.findOne(2));
        News newsArticle5 = new News("Policja nieskuteczna! Nie potrafia złapać dziaka bez nogi!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "http://www.blasty.pl/upload/images/large/2016/06/nie-mamy-sie-do-czego-przyczepic_2016-06-23_16-59-55.jpg", "http://www.blasty.pl/upload/images/large/2016/06/nie-mamy-sie-do-czego-przyczepic_2016-06-23_16-59-55.jpg", userRepository.findOne(1));

        newsRepository.save(newsArticle);
        newsRepository.save(newsArticle2);
        newsRepository.save(newsArticle3);
        newsRepository.save(newsArticle4);
        newsRepository.save(newsArticle5);
	}
}

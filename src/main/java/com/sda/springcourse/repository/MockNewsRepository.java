package com.sda.springcourse.repository;

import com.sda.springcourse.model.News;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockNewsRepository implements NewsRepository {

    private List<News> newsList;

    public MockNewsRepository() {
        this.newsList = new ArrayList<>();
    }

    @Override
    public List<News> getAll() {
//        List<News> tmpList = new ArrayList<>();
//        Collections.copy(tmpList, newsList);
//        return tmpList;
        return newsList;
    }

    @Override
    public News getById(Integer id) {
        return newsList.get(id);
    }

    @Override
    public List<News> getByUserId(Integer userId) {

        return getAll().stream()
                .filter(news -> news.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(News news) {
        news.setId(newsList.size()); //possible bug
        newsList.add(news);
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        newsList.remove(id.intValue());
        return true;
    }

    @PostConstruct
    public void init() {
        News newsArticle = new News(0, "Policja bije bezbronnych!", "Policja bije biednych i bezbronnych obywateli! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "http://karkolomny.blog.pl/files/2017/05/policja-bije-900x631.jpg", "http://karkolomny.blog.pl/files/2017/05/policja-bije-900x631.jpg", 1);
        News newsArticle2 = new News(1, "SZOK! Kaczynski jest kobietą!!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "https://img2.cda.pl/g/16713_16c9611659bb23788c7ac11ac25eda9b.jpeg", "https://img2.cda.pl/g/16713_16c9611659bb23788c7ac11ac25eda9b.jpeg", 2);
        News newsArticle3 = new News(2, "NIEDOWIERZANIE! LEKARZE ICH NIENAWIDZĄ!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://i1.kwejk.pl/k/obrazki/2016/06/baa89ad83053312302baf90b6b15f6b4.jpg", "https://i1.kwejk.pl/k/obrazki/2016/06/baa89ad83053312302baf90b6b15f6b4.jpg", 2);
        News newsArticle4 = new News(3, "HAZARDZISCI GO NIENAWIDZA! SZOKUJACE!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "http://www.penera.pl/upload/images/2016/02/hazardzisci_go_nienawidza_2016-02-29_14-46-47.jpg", "http://www.penera.pl/upload/images/2016/02/hazardzisci_go_nienawidza_2016-02-29_14-46-47.jpg", 2);
        News newsArticle5 = new News(4, "Policja nieskuteczna! Nie potrafia złapać dziaka bez nogi!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "http://www.blasty.pl/upload/images/large/2016/06/nie-mamy-sie-do-czego-przyczepic_2016-06-23_16-59-55.jpg", "http://www.blasty.pl/upload/images/large/2016/06/nie-mamy-sie-do-czego-przyczepic_2016-06-23_16-59-55.jpg", 1);

        newsList.add(newsArticle);
        newsList.add(newsArticle2);
        newsList.add(newsArticle3);
        newsList.add(newsArticle4);
        newsList.add(newsArticle5);
    }
}

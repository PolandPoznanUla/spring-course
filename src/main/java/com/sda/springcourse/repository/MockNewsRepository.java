package com.sda.springcourse.repository;

import com.sda.springcourse.model.News;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MockNewsRepository implements NewsRepository {

    private List<News> news;

    public MockNewsRepository(List<News> news) {
        this.news = news;
    }

    @Override
    public List<News> getAll() {
//        ArrayList<News> tmpList = new ArrayList<>();
//        Collections.copy(tmpList, news);
//        return tmpList;
        return news;
    }

    @Override
    public News getById(Integer id) {
        return news.get(id);
    }

    @PostConstruct
    public void init() {
        News news0 = new News(0, "one", "Lorem ipsum", "http://static.boredpanda.com/blog/wp-content/uploads/2016/08/cute-kittens-69-57b32c431e8a7__605.jpg", "#bigImgLink", 1);
        News news1 = new News(1, "one", "Lorem ipsum", "http://static.boredpanda.com/blog/wp-content/uploads/2016/08/cute-kittens-69-57b32c431e8a7__605.jpg", "#bigImgLink", 1);
        News news2 = new News(2, "two", "Lorem ipsum", "http://www.eastcottvets.co.uk/uploads/Animals/gingerkitten.jpg", "#bigImgLink", 1);
        News news3 = new News(3, "three", "Lorem ipsum", "http://orig15.deviantart.net/e713/f/2012/232/5/5/5500da4f26123863ed7ad221e176a77e-d5bqwsc.jpg", "#bigImgLink", 1);
        News news4 = new News(4, "four", "Lorem ipsum", "http://cdn3-www.cattime.com/assets/uploads/2011/08/best-kitten-names-1.jpg", "#bigImgLink", 1);
        News news5 = new News(5, "five", "Lorem ipsum", "https://i.pinimg.com/236x/95/a6/27/95a627a10fc1137f42cd5ca88aa47824--persian-kittens-orange-persian-kitten.jpg", "#bigImgLink", 1);

        news.add(news0);
        news.add(news1);
        news.add(news2);
        news.add(news3);
        news.add(news4);
        news.add(news5);
    }
}



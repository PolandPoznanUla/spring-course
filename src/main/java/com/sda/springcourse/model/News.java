package com.sda.springcourse.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Entity(name = "newsTable")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private String smallImgLink;

    private String bigImgLink;

    @ManyToOne
    private User user;

    public News() {
    }

    public News(String title, String description, String smallImgLink, String bigImgLink, User user) {
        this.title = title;
        this.description = description;
        this.smallImgLink = smallImgLink;
        this.bigImgLink = bigImgLink;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSmallImgLink() {
        return smallImgLink;
    }

    public void setSmallImgLink(String smallImgLink) {
        this.smallImgLink = smallImgLink;
    }

    public String getBigImgLink() {
        return bigImgLink;
    }

    public void setBigImgLink(String bigImgLink) {
        this.bigImgLink = bigImgLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAbbreviateDescription() {
        return StringUtils.abbreviate(description, 30);
    }
}

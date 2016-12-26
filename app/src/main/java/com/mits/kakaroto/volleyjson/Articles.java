package com.mits.kakaroto.volleyjson;

/**
 * Created by sunari on 26/12/16.
 */

public class Articles {
    private String author, title, description, url, urlImage, published;

    public Articles(String author, String title, String description, String url, String urlImage, String published) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlImage = urlImage;
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }
}
